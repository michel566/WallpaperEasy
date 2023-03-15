package com.example.core.usecase.popularusecase

import androidx.paging.Pager
import androidx.paging.PagingConfig
import androidx.paging.PagingData
import com.example.core.data.PopularRepository
import com.example.core.model.PhotoDomain
import com.example.core.usecase.PagingUseCase
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

interface GetPopularUseCase {
    operator fun invoke(params: GetPopularParams): Flow<PagingData<PhotoDomain>>
    data class GetPopularParams(val pagingConfig: PagingConfig)
}

class GetPopularUseCaseImpl @Inject constructor(
    private val repository: PopularRepository
) : PagingUseCase<GetPopularUseCase.GetPopularParams, PhotoDomain>(), GetPopularUseCase {

    override fun createFlowObservable(params: GetPopularUseCase.GetPopularParams): Flow<PagingData<PhotoDomain>> {
        return Pager(config = params.pagingConfig) {
            repository.fetchPopular(pages = params.pagingConfig.pageSize)
        }.flow
    }
}