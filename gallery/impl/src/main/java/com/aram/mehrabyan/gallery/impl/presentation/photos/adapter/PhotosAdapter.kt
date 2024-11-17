package com.aram.mehrabyan.gallery.impl.presentation.photos.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.aram.mehrabyan.gallery.impl.databinding.ItemPhotosBinding
import com.aram.mehrabyan.gallery.impl.presentation.photos.PhotoItemUiModel
import com.aram.mehrabyan.utils.imaheloader.load
import com.aram.mehrabyan.utils.ui.PagingAdapter

internal class PhotosAdapter(
    loadMore: (() -> Unit)?
) : PagingAdapter<PhotoItemUiModel, PhotosAdapter.PhotosViewHolder>(
    loadMore = loadMore,
    diffCallback = PhotosDiffCallback()
) {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): PhotosViewHolder {
        val binding = ItemPhotosBinding.inflate(
            LayoutInflater.from(parent.context),
            parent,
            false
        )
        return PhotosViewHolder(binding = binding)
    }

    override fun onBindViewHolder(holder: PhotosViewHolder, position: Int) {
        super.onBindViewHolder(holder, position)
        holder.bind(getItem(position))
    }

    class PhotosViewHolder(
        private val binding: ItemPhotosBinding
    ) : RecyclerView.ViewHolder(binding.root) {

        fun bind(item: PhotoItemUiModel) {
            binding.tvUserName.text = item.userName
            binding.thumbnail.load(item.previewURL)
        }
    }
}