package com.example.wallpapereasy.framework.di

import com.example.core.data.dbrepository.GalleryLocalDataSource
import com.example.core.data.dbrepository.GalleryRepository
import com.example.wallpapereasy.framework.db.repository.GalleryRepositoryImpl
import com.example.wallpapereasy.framework.local.GalleryLocalDataSourceImpl
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent

@Module
@InstallIn(SingletonComponent::class)
interface GalleryRepositoryModule {

    @Binds
    fun bindGalleryRepository(galleryRepositoryImpl: GalleryRepositoryImpl): GalleryRepository

    @Binds
    fun bindLocalDataSource(localDataSourceImpl: GalleryLocalDataSourceImpl): GalleryLocalDataSource
}