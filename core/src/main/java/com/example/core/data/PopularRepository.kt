package com.example.core.data

import androidx.paging.PagingSource
import com.example.core.model.PhotoDomain

interface PopularRepository {
    fun fetchPopular(pages: Int): PagingSource<Int, PhotoDomain>
}