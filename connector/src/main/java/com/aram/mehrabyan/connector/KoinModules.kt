package com.aram.mehrabyan.connector

import com.aram.mehrabyan.authimpl.di.authModule
import com.aram.mehrabyan.gallery.impl.di.galleryModule
import com.aram.mehrabyan.network.di.networkModule

fun getModules() = listOf(
    networkModule(),
    authModule(),
    galleryModule()
)