package com.aram.mehrabyan.gallery.impl.data.entity

import com.google.gson.annotations.SerializedName

internal data class GalleryItemApiResult(
    @SerializedName("id") val id: Long,
    @SerializedName("previewURL") val previewURL: String,
    @SerializedName("user") val userName: String
)
