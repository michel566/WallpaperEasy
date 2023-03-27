package com.example.wallpapereasy.framework.di

import com.example.core.usecase.base.AppCoroutimeDispatcher
import com.example.core.usecase.base.CoroutineDispatchers
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent

@Module
@InstallIn(SingletonComponent::class)
interface DispatcherModule {

    @Binds
    fun bindDispatcher(appCoroutimeDispatcher: AppCoroutimeDispatcher): CoroutineDispatchers
}