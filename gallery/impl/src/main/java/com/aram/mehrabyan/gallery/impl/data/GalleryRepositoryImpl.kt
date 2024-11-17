package com.aram.mehrabyan.gallery.impl.data

import com.aram.mehrabyan.gallery.impl.data.entity.GalleryContentApiResult
import com.aram.mehrabyan.network.key.ApiKeyProvider
import com.aram.mehrabyan.utils.concurrency.PBDispatchers
import com.aram.mehrabyan.utils.model.ActionResult
import kotlinx.coroutines.withContext
import retrofit2.Response

internal class GalleryRepositoryImpl(
    private val service: GalleryService,
    private val apiKeyProvider: ApiKeyProvider,
    private val pbDispatchers: PBDispatchers
) : GalleryRepository {

    override suspend fun getPhotos(page: Int): ActionResult<GalleryContentApiResult> {
        return try {
            withContext(pbDispatchers.ioDispatcher) {
                handleApiResult(service.getPhotos(key = apiKeyProvider.apiKey(), page = page))
            }
        } catch (exception: Exception) {
            ActionResult.Error(exception = exception)
        }
    }

    override suspend fun getPhotoById(id: Long): ActionResult<GalleryContentApiResult> {
        return try {
            withContext(pbDispatchers.ioDispatcher) {
                handleApiResult(service.getPhotoById(key = apiKeyProvider.apiKey(), id = id))
            }
        } catch (exception: Exception) {
            ActionResult.Error(exception = exception)
        }
    }

    private fun <T> handleApiResult(response: Response<T>): ActionResult<T> {
        return if (response.isSuccessful) {
            response.body()?.let { data ->
                ActionResult.Success(data)
            } ?: ActionResult.Error()
        } else {
            ActionResult.Error()
        }
    }
}