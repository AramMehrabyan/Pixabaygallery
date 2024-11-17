package com.aram.mehrabyan.gallery.impl.domain.photos

import com.aram.mehrabyan.gallery.impl.data.GalleryRepository
import com.aram.mehrabyan.gallery.impl.data.entity.GalleryItemApiResult
import com.aram.mehrabyan.gallery.impl.presentation.photos.PhotoItemUiModel
import com.aram.mehrabyan.gallery.impl.presentation.photos.PhotosState
import com.aram.mehrabyan.utils.mapper.Mapper
import com.aram.mehrabyan.utils.model.ActionResult

internal class PhotosUseCaseImpl(
    private val repository: GalleryRepository,
    private val mapper: Mapper<GalleryItemApiResult, PhotoItemUiModel>
) : PhotosUseCase {

    override suspend fun getPhotos(page: Int): ActionResult<PhotosState> {
        return when (val result = repository.getPhotos(page)) {
            is ActionResult.Success -> {
                val data = PhotosState(
                    currentPage = page,
                    items = mapper.map(result.data.items)
                )
                ActionResult.Success(data)
            }
            is ActionResult.Error -> {
                result
            }
        }
    }
}