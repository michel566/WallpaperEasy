package com.example.wallpapereasy.framework.repository

import androidx.paging.PagingSource
import com.example.core.data.PopularRepository
import com.example.core.data.RemoteDataSource
import com.example.core.model.PhotoDomain
import com.example.wallpapereasy.framework.network.response.DataWrapperResponse
import com.example.wallpapereasy.framework.paging.PopularPagingSource
import javax.inject.Inject

class PopularRepositoryImpl @Inject constructor(
    private val remoteDataSource: RemoteDataSource<DataWrapperResponse>
): PopularRepository {

    override fun fetchPopular(pages: Int): PagingSource<Int, PhotoDomain> {
        return PopularPagingSource(dataSource = remoteDataSource, pages)
    }

}