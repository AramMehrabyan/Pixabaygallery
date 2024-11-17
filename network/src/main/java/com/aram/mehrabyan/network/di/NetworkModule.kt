package com.aram.mehrabyan.network.di

import com.aram.mehrabyan.network.HttpClientCreator
import com.aram.mehrabyan.network.RestApiCreator
import com.aram.mehrabyan.network.RestApiCreatorImpl
import com.aram.mehrabyan.network.key.ApiKeyProvider
import com.aram.mehrabyan.network.key.ApiKeyProviderImpl
import org.koin.dsl.module

fun networkModule() = module {

    single<RestApiCreator> {
        RestApiCreatorImpl(retrofit = HttpClientCreator.createClient())
    }

    single<ApiKeyProvider> {
        ApiKeyProviderImpl()
    }
}