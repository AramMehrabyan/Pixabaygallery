package com.aram.mehrabyan.gallery.impl.data

import com.aram.mehrabyan.gallery.impl.data.entity.GalleryContentApiResult
import com.aram.mehrabyan.network.key.ApiKeyProvider
import com.aram.mehrabyan.utils.concurrency.PBDispatchers
import com.aram.mehrabyan.utils.model.ActionResult
import kotlinx.coroutines.withContext

internal class GalleryRepositoryImpl(
    private val service: GalleryService,
    private val apiKeyProvider: ApiKeyProvider,
    private val pbDispatchers: PBDispatchers
) : GalleryRepository {

    override suspend fun getPhotos(page: Int): ActionResult<GalleryContentApiResult> {
        return try {
            withContext(pbDispatchers.ioDispatcher) {
                handlePhotosRequest(page = page)
            }
        } catch (exception: Exception) {
            ActionResult.Error(exception = exception)
        }
    }

    private suspend fun handlePhotosRequest(page: Int): ActionResult<GalleryContentApiResult> {
        val apiResult = service.getPhotos(key = apiKeyProvider.apiKey(), page = page)

        return if (apiResult.isSuccessful) {
            apiResult.body()?.let { data ->
                ActionResult.Success(data)
            } ?: ActionResult.Error()
        } else {
            ActionResult.Error()
        }
    }
}