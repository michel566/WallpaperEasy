package com.example.wallpapereasy.framework.db.repository

import com.example.core.data.dbrepository.GalleryLocalDataSource
import com.example.core.data.dbrepository.GalleryRepository
import com.example.core.model.PhotoDomain
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

class GalleryRepositoryImpl @Inject constructor(
    private val dataSource: GalleryLocalDataSource
) : GalleryRepository {
    override suspend fun insert(domain: PhotoDomain)  =
        dataSource.insert(domain)

    override suspend fun get(): Flow<List<PhotoDomain>> =
        dataSource.get()

    override suspend fun delete(domain: PhotoDomain)  =
        dataSource.delete(domain)
}