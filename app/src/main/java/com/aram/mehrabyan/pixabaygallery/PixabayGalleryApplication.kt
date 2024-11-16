package com.aram.mehrabyan.pixabaygallery

import android.app.Application
import com.aram.mehrabyan.connector.getModules
import org.koin.android.ext.koin.androidContext
import org.koin.core.context.startKoin

class PixabayGalleryApplication: Application() {

    override fun onCreate() {
        super.onCreate()

        startKoin {
            androidContext(this@PixabayGalleryApplication)
            modules(getModules())
        }
    }
}