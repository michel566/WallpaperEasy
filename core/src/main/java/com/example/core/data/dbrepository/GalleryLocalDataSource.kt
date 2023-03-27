package com.example.core.data.dbrepository

import com.example.core.model.PhotoDomain
import kotlinx.coroutines.flow.Flow

interface GalleryLocalDataSource {
    suspend fun insert(domain: PhotoDomain)
    suspend fun get(): Flow<List<PhotoDomain>>
    suspend fun delete(domain: PhotoDomain)
}