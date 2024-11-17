package com.aram.mehrabyan.gallery.impl.domain.mapper

import com.aram.mehrabyan.gallery.impl.data.entity.GalleryItemDetailApiResult
import com.aram.mehrabyan.gallery.impl.presentation.photodetail.PhotoDetailUiState
import com.aram.mehrabyan.utils.mapper.Mapper

internal class PhotoDetailMapper : Mapper<GalleryItemDetailApiResult, PhotoDetailUiState>() {

    override fun map(input: GalleryItemDetailApiResult): PhotoDetailUiState {
        return PhotoDetailUiState(
            id = input.id,
            largeImageURL = input.largeImageURL,
            type = input.type,
            tags = input.tags,
            userName = input.userName,
            imageSize = input.imageSize,
            viewsCount = input.viewsCount,
            likesCount = input.likesCount,
            commentsCount = input.commentsCount,
            favoritesCount = input.favoritesCount,
            downloadsCount = input.downloadsCount
        )
    }
}