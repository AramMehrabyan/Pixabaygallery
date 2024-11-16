package com.aram.mehrabyan.gallery.impl.di

import com.aram.mehrabyan.gallery.api.GalleryLauncher
import com.aram.mehrabyan.gallery.impl.data.GalleryService
import com.aram.mehrabyan.gallery.impl.launcher.GalleryLauncherImpl
import com.aram.mehrabyan.network.RestApiCreator
import org.koin.dsl.module

fun galleryModule() = module {

    single<GalleryService> {
        get<RestApiCreator>().createApiService(GalleryService::class.java)
    }

    factory<GalleryLauncher> {
        GalleryLauncherImpl()
    }
}