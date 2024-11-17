package com.aram.mehrabyan.gallery.impl.data

import com.aram.mehrabyan.gallery.impl.data.entity.GalleryContentApiResult
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Query

internal interface GalleryService {

    @GET("api/")
    suspend fun getPhotos(
        @Query("key") key: String,
        @Query("page") page: Int,
        @Query("per_page") perPage: Int = PER_PAGE_LIMIT
    ): Response<GalleryContentApiResult>

    companion object {
        private const val PER_PAGE_LIMIT = 30
    }
}