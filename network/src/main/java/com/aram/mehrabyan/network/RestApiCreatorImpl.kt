package com.aram.mehrabyan.network

import retrofit2.Retrofit

internal class RestApiCreatorImpl(
    private val retrofit: Retrofit
) : RestApiCreator {

    override fun <API_SERVICE_INTERFACE> createApiService(
        apiClass: Class<API_SERVICE_INTERFACE>
    ): API_SERVICE_INTERFACE {
        return retrofit.create(apiClass)
    }
}