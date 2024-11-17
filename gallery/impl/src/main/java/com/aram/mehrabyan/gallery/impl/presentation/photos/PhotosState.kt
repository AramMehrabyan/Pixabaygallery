package com.aram.mehrabyan.gallery.impl.presentation.photos

internal data class PhotosState(
    val items: List<PhotoItemUiModel>,
    val currentPage: Int = INITIAL_PAGE
) {
    companion object {
        const val INITIAL_PAGE = 1
    }
}

data class PhotoItemUiModel(
    val id: Long,
    val previewURL: String,
    val userName: String
)