package com.example.wallpapereasy.ui.fragment.adapter.photoadapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.core.model.PhotoDomain
import com.example.wallpapereasy.R
import com.example.wallpapereasy.databinding.ItemPhotoBinding
import com.example.wallpapereasy.ui.extension.loadBlurredImageWithPlaceholder

class PhotoViewHolder(
    itemBinding: ItemPhotoBinding,
    private val photoCallback: (photo: PhotoDomain) -> Unit
): RecyclerView.ViewHolder(itemBinding.root) {

    private val image = itemBinding.image
    private val name = itemBinding.name

    fun bind(photo: PhotoDomain){
//        Glide.with(itemView.context)
//            .load(photo.srcDomain.original)
//            .centerCrop()
//            .fallback(R.drawable.baseline_broken)
//            .into(image)

        image.loadBlurredImageWithPlaceholder(
            imageUrl = photo.srcDomain?.original,
            placeholderColor = photo.avgColor
        )

        name.text = photo.photographer

        itemView.setOnClickListener {
            photoCallback.invoke(photo)
        }
    }

    companion object{
        fun create(parent: ViewGroup,
                   photoCallback: (photo: PhotoDomain) -> Unit) : PhotoViewHolder {
            val inflater = LayoutInflater.from(parent.context)
            val itemBinding = ItemPhotoBinding.inflate(inflater, parent, false)
            return PhotoViewHolder(itemBinding, photoCallback)
        }
    }
}