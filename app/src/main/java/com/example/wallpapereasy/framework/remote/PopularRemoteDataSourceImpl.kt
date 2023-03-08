package com.example.wallpapereasy.framework.remote

import com.example.core.data.RemoteDataSource
import com.example.wallpapereasy.framework.network.api.WallpapersApi
import com.example.wallpapereasy.framework.network.response.DataWrapperResponse
import javax.inject.Inject

class PopularRemoteDataSourceImpl @Inject constructor(
    private val api: WallpapersApi
) : RemoteDataSource<DataWrapperResponse> {

    override suspend fun fetchPopular(page: Int, perPage: Int): DataWrapperResponse =
        api.getPopularWallpapers(page, perPage)

}