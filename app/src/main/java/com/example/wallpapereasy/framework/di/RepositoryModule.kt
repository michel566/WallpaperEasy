package com.example.wallpapereasy.framework.di

import com.example.core.data.PopularRepository
import com.example.core.data.RemoteDataSource
import com.example.wallpapereasy.framework.network.response.DataWrapperResponse
import com.example.wallpapereasy.framework.remote.PopularRemoteDataSourceImpl
import com.example.wallpapereasy.framework.repository.PopularRepositoryImpl
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent

@Module
@InstallIn(SingletonComponent::class)
interface RepositoryModule {

    @Binds
    fun bindPopularRepository(repositoryImpl: PopularRepositoryImpl): PopularRepository

    @Binds
    fun bindRemoteDataSource(dataSourceImpl: PopularRemoteDataSourceImpl): RemoteDataSource<DataWrapperResponse>
}