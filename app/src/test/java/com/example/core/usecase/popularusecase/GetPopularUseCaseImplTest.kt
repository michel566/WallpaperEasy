package com.example.core.usecase.popularusecase

import androidx.paging.PagingConfig
import com.example.core.data.PopularRepository
import com.example.testing.MainCoroutinesRule
import com.example.testing.model.WallpapersFactory
import com.example.testing.pagingsource.PagingSourceFactory
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.flow.first
import org.junit.Assert
import org.junit.Before
import org.junit.Rule
import org.junit.Test
import org.junit.runner.RunWith
import org.mockito.Mock
import org.mockito.MockitoAnnotations
import org.mockito.junit.MockitoJUnitRunner
import org.mockito.kotlin.mock
import org.mockito.kotlin.verify
import org.mockito.kotlin.whenever

@ExperimentalCoroutinesApi
@RunWith(MockitoJUnitRunner::class)
class GetPopularUseCaseImplTest{

    @get:Rule
    var mainCoroutinesRule = MainCoroutinesRule()

    @Mock
    private val popularRepository = mock<PopularRepository>()

    private lateinit var popularUseCase: GetPopularUseCase

    private val photos = WallpapersFactory().create(WallpapersFactory.Photo.PhotoDomainSuccess)
    private val mockingPagingSource = PagingSourceFactory().create(listOf(photos))

    @Before
    fun setup(){
        popularUseCase = GetPopularUseCaseImpl(repository = popularRepository)
    }

    @Test
    fun `should validate flow paging data creation when invoke from use case is called`() {
        whenever(popularRepository.fetchPopular(40)).thenReturn(mockingPagingSource)

        val result = popularUseCase.invoke(GetPopularUseCase.GetPopularParams(PagingConfig(40)))

        verify(popularRepository).fetchPopular(40)
        Assert.assertNotNull(result)
    }

}