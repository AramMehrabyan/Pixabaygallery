package com.aram.mehrabyan.gallery.impl.data.entity

import com.google.gson.annotations.SerializedName

internal data class GalleryContentApiResult(
    @SerializedName("total") val total: Long,
    @SerializedName("totalHits") val totalHits: Long,
    @SerializedName("hits") val items: List<GalleryItemApiResult>
)
