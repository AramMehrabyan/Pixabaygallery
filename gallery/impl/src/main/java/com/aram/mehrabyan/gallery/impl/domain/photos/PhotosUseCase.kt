package com.aram.mehrabyan.gallery.impl.domain.photos

import com.aram.mehrabyan.gallery.impl.presentation.photos.PhotosState
import com.aram.mehrabyan.utils.model.ActionResult

internal interface PhotosUseCase {

    suspend fun getPhotos(page: Int): ActionResult<PhotosState>
}