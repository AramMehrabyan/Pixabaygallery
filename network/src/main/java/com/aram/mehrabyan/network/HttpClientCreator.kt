package com.aram.mehrabyan.network

import okhttp3.OkHttpClient
import retrofit2.Converter
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

internal object HttpClientCreator {

    fun createClient(): Retrofit {
        return Retrofit.Builder().apply {
            baseUrl(BASE_URL)
            client(createOkHttpClient())
            addConverterFactory(createConverterFactory())
        }.build()
    }

    private fun createConverterFactory(): Converter.Factory {
        return GsonConverterFactory.create()
    }

    private fun createOkHttpClient(): OkHttpClient {
        return OkHttpClient.Builder().build()
    }

    private const val BASE_URL = "https://pixabay.com/"
}