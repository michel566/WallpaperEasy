package com.example.wallpapereasy.framework.local

import com.example.core.data.dbrepository.GalleryLocalDataSource
import com.example.core.model.PhotoDomain
import com.example.wallpapereasy.framework.db.dao.WallpaperDao
import com.example.wallpapereasy.framework.db.entity.PhotoEntity
import com.example.wallpapereasy.framework.db.entity.toPhotoDomain
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map
import javax.inject.Inject

class GalleryLocalDataSourceImpl @Inject constructor(
    private val dao: WallpaperDao
): GalleryLocalDataSource{

    override suspend fun insert(domain: PhotoDomain) =
        dao.insert(domain.toEntity())

    override suspend fun get(): Flow<List<PhotoDomain>> =
        dao.getAllPhotos().map {
            it.toPhotoDomain()
        }

    override suspend fun delete(domain: PhotoDomain) =
        dao.delete(domain.toEntity())

    private fun PhotoDomain.toEntity() =
        PhotoEntity(
            id = this.id?: 0,
            photo = this.srcDomain?.original ?: "",
            avgColor = this.avgColor ?: "",
            photographer =  this.photographer ?: ""
        )

}