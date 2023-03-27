package com.example.core.usecase.getgalleryusecase

import com.example.core.data.dbrepository.GalleryRepository
import com.example.core.model.PhotoDomain
import com.example.core.usecase.base.CoroutineDispatchers
import com.example.core.usecase.base.FlowUseCase
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.withContext
import javax.inject.Inject

interface GetGalleryUseCase {
    suspend operator fun invoke(params: Unit) : Flow<List<PhotoDomain>>
}

class GetGalleryUseCaseImpl @Inject constructor(
    private val repository: GalleryRepository,
    private val dispatcher: CoroutineDispatchers
): FlowUseCase<Unit, List<PhotoDomain>>(), GetGalleryUseCase{

    override suspend fun createFlowObservable(params: Unit): Flow<List<PhotoDomain>> {
        return withContext(dispatcher.io()){
            repository.get()
        }
    }

}