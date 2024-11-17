package com.aram.mehrabyan.gallery.impl.domain.photodetail

import com.aram.mehrabyan.gallery.impl.presentation.photodetail.PhotoDetailUiState
import com.aram.mehrabyan.utils.model.ActionResult

internal interface PhotoDetailUseCase {

    suspend fun getPhotoDetails(id: Long): ActionResult<PhotoDetailUiState>
}