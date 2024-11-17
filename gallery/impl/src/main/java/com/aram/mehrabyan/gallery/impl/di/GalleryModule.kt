package com.aram.mehrabyan.gallery.impl.di

import com.aram.mehrabyan.gallery.api.GalleryLauncher
import com.aram.mehrabyan.gallery.impl.data.GalleryRepository
import com.aram.mehrabyan.gallery.impl.data.GalleryRepositoryImpl
import com.aram.mehrabyan.gallery.impl.data.GalleryService
import com.aram.mehrabyan.gallery.impl.data.entity.GalleryItemApiResult
import com.aram.mehrabyan.gallery.impl.domain.mapper.PhotosMapper
import com.aram.mehrabyan.gallery.impl.domain.photos.PhotosUseCase
import com.aram.mehrabyan.gallery.impl.domain.photos.PhotosUseCaseImpl
import com.aram.mehrabyan.gallery.impl.launcher.GalleryLauncherImpl
import com.aram.mehrabyan.gallery.impl.presentation.photos.PhotoItemUiModel
import com.aram.mehrabyan.gallery.impl.presentation.photos.PhotosViewModel
import com.aram.mehrabyan.network.RestApiCreator
import com.aram.mehrabyan.utils.mapper.Mapper
import org.koin.core.module.dsl.viewModel
import org.koin.dsl.module

fun galleryModule() = module {

    single<GalleryService> {
        get<RestApiCreator>().createApiService(GalleryService::class.java)
    }

    factory<GalleryLauncher> {
        GalleryLauncherImpl()
    }

    factory<Mapper<GalleryItemApiResult, PhotoItemUiModel>> {
        PhotosMapper()
    }

    factory<GalleryRepository> {
        GalleryRepositoryImpl(service = get(), apiKeyProvider = get(), pbDispatchers = get())
    }

    factory<PhotosUseCase> {
        PhotosUseCaseImpl(repository = get(), mapper = get())
    }

    viewModel {
        PhotosViewModel(photosUseCase = get())
    }
}