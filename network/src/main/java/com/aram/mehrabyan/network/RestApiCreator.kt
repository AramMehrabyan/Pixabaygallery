package com.aram.mehrabyan.network

interface RestApiCreator {

    fun <API_SERVICE_INTERFACE> createApiService(
        apiClass: Class<API_SERVICE_INTERFACE>
    ): API_SERVICE_INTERFACE
}