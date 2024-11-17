package com.aram.mehrabyan.gallery.impl.data

import com.aram.mehrabyan.gallery.impl.data.entity.GalleryContentApiResult
import com.aram.mehrabyan.utils.model.ActionResult

internal interface GalleryRepository {

    suspend fun getPhotos(page: Int): ActionResult<GalleryContentApiResult>

    suspend fun getPhotoById(id: Long): ActionResult<GalleryContentApiResult>
}