package com.aram.mehrabyan.connector

import com.aram.mehrabyan.authimpl.di.authModule
import com.aram.mehrabyan.gallery.impl.di.galleryModule
import com.aram.mehrabyan.network.di.networkModule
import com.aram.mehrabyan.utils.di.utilsModule

fun getModules() = listOf(
    utilsModule(),
    networkModule(),
    authModule(),
    galleryModule()
)