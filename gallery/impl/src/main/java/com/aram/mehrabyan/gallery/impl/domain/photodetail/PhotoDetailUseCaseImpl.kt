package com.aram.mehrabyan.gallery.impl.domain.photodetail

import com.aram.mehrabyan.gallery.impl.data.GalleryRepository
import com.aram.mehrabyan.gallery.impl.data.entity.GalleryItemDetailApiResult
import com.aram.mehrabyan.gallery.impl.presentation.photodetail.PhotoDetailUiState
import com.aram.mehrabyan.utils.mapper.Mapper
import com.aram.mehrabyan.utils.model.ActionResult

internal class PhotoDetailUseCaseImpl(
    private val repository: GalleryRepository,
    private val mapper: Mapper<GalleryItemDetailApiResult, PhotoDetailUiState>
) : PhotoDetailUseCase {

    override suspend fun getPhotoDetails(id: Long): ActionResult<PhotoDetailUiState> {
        return when (val result = repository.getPhotoById(id)) {
            is ActionResult.Success -> {
                result.data.items.firstOrNull()?.let { item ->
                    ActionResult.Success(mapper.map(item))
                } ?: ActionResult.Error()
            }
            is ActionResult.Error -> {
                result
            }
        }
    }
}