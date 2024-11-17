package com.aram.mehrabyan.gallery.impl.di

import com.aram.mehrabyan.gallery.api.GalleryLauncher
import com.aram.mehrabyan.gallery.impl.data.GalleryRepository
import com.aram.mehrabyan.gallery.impl.data.GalleryRepositoryImpl
import com.aram.mehrabyan.gallery.impl.data.GalleryService
import com.aram.mehrabyan.gallery.impl.data.entity.GalleryItemDetailApiResult
import com.aram.mehrabyan.gallery.impl.domain.mapper.PhotoDetailMapper
import com.aram.mehrabyan.gallery.impl.domain.mapper.PhotosMapper
import com.aram.mehrabyan.gallery.impl.domain.photodetail.PhotoDetailUseCase
import com.aram.mehrabyan.gallery.impl.domain.photodetail.PhotoDetailUseCaseImpl
import com.aram.mehrabyan.gallery.impl.domain.photos.PhotosUseCase
import com.aram.mehrabyan.gallery.impl.domain.photos.PhotosUseCaseImpl
import com.aram.mehrabyan.gallery.impl.launcher.GalleryLauncherImpl
import com.aram.mehrabyan.gallery.impl.presentation.photodetail.PhotoDetailUiState
import com.aram.mehrabyan.gallery.impl.presentation.photodetail.PhotoDetailViewModel
import com.aram.mehrabyan.gallery.impl.presentation.photos.PhotoItemUiModel
import com.aram.mehrabyan.gallery.impl.presentation.photos.PhotosViewModel
import com.aram.mehrabyan.network.RestApiCreator
import com.aram.mehrabyan.utils.mapper.Mapper
import org.koin.core.module.dsl.viewModel
import org.koin.core.qualifier.named
import org.koin.dsl.module

fun galleryModule() = module {

    single<GalleryService> {
        get<RestApiCreator>().createApiService(GalleryService::class.java)
    }

    factory<GalleryLauncher> {
        GalleryLauncherImpl()
    }

    factory<Mapper<GalleryItemDetailApiResult, PhotoItemUiModel>>(named(PHOTO_LIST_ITEM_MAPPER)) {
        PhotosMapper()
    }

    factory<Mapper<GalleryItemDetailApiResult, PhotoDetailUiState>>(named(PHOTO_ITEM_DETAILS_MAPPER)) {
        PhotoDetailMapper()
    }

    factory<GalleryRepository> {
        GalleryRepositoryImpl(service = get(), apiKeyProvider = get(), pbDispatchers = get())
    }

    factory<PhotosUseCase> {
        PhotosUseCaseImpl(repository = get(), mapper = get(named(PHOTO_LIST_ITEM_MAPPER)))
    }

    factory<PhotoDetailUseCase> {
        PhotoDetailUseCaseImpl(repository = get(), mapper = get(named(PHOTO_ITEM_DETAILS_MAPPER)))
    }

    viewModel {
        PhotosViewModel(photosUseCase = get())
    }

    viewModel { (id: Long) ->
        PhotoDetailViewModel(id = id, photoDetailUseCase = get())
    }
}