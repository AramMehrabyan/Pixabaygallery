package com.aram.mehrabyan.gallery.impl.presentation.photodetail


internal data class PhotoDetailUiState(
    val id: Long,
    val largeImageURL: String,
    val type: String,
    val tags: String,
    val userName: String,
    val imageSize: Long,
    val viewsCount: Long,
    val likesCount: Long,
    val commentsCount: Long,
    val favoritesCount: Long,
    val downloadsCount: Long
)
