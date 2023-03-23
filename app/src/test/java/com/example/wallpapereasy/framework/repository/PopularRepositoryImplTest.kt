package com.example.wallpapereasy.framework.repository

import androidx.paging.PagingSource
import com.example.core.data.RemoteDataSource
import com.example.core.model.PhotoDomain
import com.example.testing.MainCoroutinesRule
import com.example.testing.model.WallpapersFactory
import com.example.wallpapereasy.framework.network.response.DataWrapperResponse
import com.example.wallpapereasy.framework.paging.PopularPagingSource
import com.example.wallpapereasy.ui.fragment.popular.factory.DataWrapperResponseFactory
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.test.runTest
import org.junit.Assert.*
import org.junit.Before
import org.junit.Rule
import org.junit.Test
import org.junit.runner.RunWith
import org.mockito.Mock
import org.mockito.junit.MockitoJUnitRunner
import org.mockito.kotlin.any
import org.mockito.kotlin.whenever

@ExperimentalCoroutinesApi
@RunWith(MockitoJUnitRunner::class)
class PopularRepositoryImplTest {

    @get:Rule
    var mainCoroutinesRule = MainCoroutinesRule()

    @Mock
    lateinit var remoteDataSource: RemoteDataSource<DataWrapperResponse>

    private lateinit var popularPagingSource: PopularPagingSource
    private lateinit var repository: PopularRepositoryImpl

    private val factory = DataWrapperResponseFactory()
    private val wallpapersFactory =
        WallpapersFactory().create(WallpapersFactory.Photo.PhotoDomainSuccess)

    @Before
    fun setup() {
        popularPagingSource = PopularPagingSource(remoteDataSource, 40)
        repository = PopularRepositoryImpl(remoteDataSource)
    }

    @Test
    fun `should validate return from repository`() = runTest {
        val result = repository.fetchPopular(40)

        assertNotNull(result)
    }

    @Test
    fun `should validate paging data success when invoke from repository is called`() = runTest {
        whenever(remoteDataSource.fetchPopular(any(), any()))
            .thenReturn(factory.create())

        val result = popularPagingSource.load(
            PagingSource.LoadParams.Refresh(
                key = null,
                loadSize = 2,
                placeholdersEnabled = false
            )
        )

        val expected = listOf(wallpapersFactory, wallpapersFactory)

        assertEquals(
            PagingSource.LoadResult.Page(
                data = expected,
                prevKey = null,
                nextKey = 2
            ),
            result
        )
    }

    @Test
    fun `should validate paging data error when invoke from repository is called`() = runTest {
        val exception = RuntimeException()

        whenever(remoteDataSource.fetchPopular(any(), any()))
            .thenThrow(exception)

        val result = popularPagingSource.load(
            PagingSource.LoadParams.Refresh(
                key = null,
                loadSize = 40,
                placeholdersEnabled = false
            )
        )

        assertEquals(
            PagingSource.LoadResult.Error<Int, PhotoDomain>(exception),
            result
        )
    }

}