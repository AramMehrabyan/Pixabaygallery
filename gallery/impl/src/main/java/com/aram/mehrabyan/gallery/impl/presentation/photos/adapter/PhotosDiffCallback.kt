package com.aram.mehrabyan.gallery.impl.presentation.photos.adapter

import androidx.recyclerview.widget.DiffUtil
import com.aram.mehrabyan.gallery.impl.presentation.photos.PhotoItemUiModel

internal class PhotosDiffCallback : DiffUtil.ItemCallback<PhotoItemUiModel>() {

    override fun areItemsTheSame(oldItem: PhotoItemUiModel, newItem: PhotoItemUiModel): Boolean {
        return oldItem.id == newItem.id
    }

    override fun areContentsTheSame(oldItem: PhotoItemUiModel, newItem: PhotoItemUiModel): Boolean {
        return oldItem == newItem
    }
}