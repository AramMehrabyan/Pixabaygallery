package com.aram.mehrabyan.network.key

import com.aram.mehrabyan.network.BuildConfig

internal class ApiKeyProviderImpl: ApiKeyProvider {

    override fun apiKey(): String {
        return BuildConfig.API_KEY
    }
}