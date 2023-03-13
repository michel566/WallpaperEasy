package com.example.wallpapereasy.ui.fragment.adapter.photoadapter

import android.view.ViewGroup
import androidx.paging.PagingDataAdapter
import androidx.recyclerview.widget.DiffUtil
import com.example.core.model.PhotoDomain

class PhotoAdapter(
    private val photoCallback: ((photo: PhotoDomain) -> Unit)
): PagingDataAdapter<PhotoDomain, PhotoViewHolder>(diffCallback) {

    override fun onBindViewHolder(holder: PhotoViewHolder, position: Int) {
        getItem(position)?.let {
            holder.bind(it)
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): PhotoViewHolder =
        PhotoViewHolder.create(parent, photoCallback)

    companion object {
        private val diffCallback = object : DiffUtil.ItemCallback<PhotoDomain>() {
            override fun areItemsTheSame(oldItem: PhotoDomain, newItem: PhotoDomain): Boolean {
                return oldItem.url == newItem.url
            }

            override fun areContentsTheSame(oldItem: PhotoDomain, newItem: PhotoDomain): Boolean {
                return oldItem == newItem
            }

        }
    }

}