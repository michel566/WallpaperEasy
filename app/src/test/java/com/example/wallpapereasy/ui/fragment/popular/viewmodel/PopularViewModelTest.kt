package com.example.wallpapereasy.ui.fragment.popular.viewmodel

import androidx.paging.PagingData
import com.example.core.model.PhotoDomain
import com.example.core.model.SrcDomain
import com.example.core.usecase.popularusecase.GetPopularUseCase
import com.example.testing.MainCoroutinesRule
import com.example.testing.model.WallpapersFactory
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.flow.first
import kotlinx.coroutines.flow.flowOf
import kotlinx.coroutines.test.runTest
import org.junit.Assert
import org.junit.Before
import org.junit.Rule
import org.junit.Test
import org.junit.runner.RunWith
import org.mockito.Mock
import org.mockito.junit.MockitoJUnitRunner
import org.mockito.kotlin.any
import org.mockito.kotlin.whenever

@RunWith(MockitoJUnitRunner::class)
@ExperimentalCoroutinesApi
internal class PopularViewModelTest {

    @get:Rule
    var mainCoroutinesRule = MainCoroutinesRule()

    @Mock
    lateinit var popularUseCase: GetPopularUseCase
    private lateinit var popularViewModel: PopularViewModel

    @Before
    fun setup() {
        popularViewModel = PopularViewModel(popularUseCase)
    }

    @Test
    fun `Should validate pagination data`() = runTest {
        whenever(popularUseCase(any())).thenReturn(flowOf(pagingDataMock))
        val result = popularViewModel.popularWallpapers()

        Assert.assertNotNull(result.first())
    }

    @Test(expected = RuntimeException::class)
    fun `Should return an empty PagingData When an error occurred`() = runTest {
        //Arrange
        whenever(popularUseCase(any())).thenThrow(RuntimeException())

        //Act
        popularViewModel.popularWallpapers()
    }

    private val wallpapersFactory = WallpapersFactory()
    private val pagingDataMock = PagingData.from(
        listOf(
            wallpapersFactory.create(WallpapersFactory.Photo.PhotoDomainSuccess),
            wallpapersFactory.create(WallpapersFactory.Photo.PhotoDomainSuccess)
        )
    )


}