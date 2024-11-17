package com.aram.mehrabyan.gallery.impl.domain.mapper

import com.aram.mehrabyan.gallery.impl.data.entity.GalleryItemDetailApiResult
import com.aram.mehrabyan.gallery.impl.presentation.photos.PhotoItemUiModel
import com.aram.mehrabyan.utils.mapper.Mapper

internal class PhotosMapper : Mapper<GalleryItemDetailApiResult, PhotoItemUiModel>() {

    override fun map(input: GalleryItemDetailApiResult): PhotoItemUiModel {
        return PhotoItemUiModel(
            id = input.id,
            previewURL = input.previewURL,
            userName = input.userName
        )
    }
}