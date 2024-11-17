package com.aram.mehrabyan.gallery.impl.data.entity

import com.google.gson.annotations.SerializedName

internal data class GalleryItemDetailApiResult(
    @SerializedName("id") val id: Long,
    @SerializedName("previewURL") val previewURL: String,
    @SerializedName("largeImageURL") val largeImageURL: String,
    @SerializedName("type") val type: String,
    @SerializedName("tags") val tags: String,
    @SerializedName("user") val userName: String,
    @SerializedName("imageSize") val imageSize: Long,
    @SerializedName("views") val viewsCount: Long,
    @SerializedName("likes") val likesCount: Long,
    @SerializedName("comments") val commentsCount: Long,
    @SerializedName("collections") val favoritesCount: Long,
    @SerializedName("downloads") val downloadsCount: Long
)
