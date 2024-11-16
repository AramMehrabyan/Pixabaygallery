package com.aram.mehrabyan.gallery.impl.launcher

import android.content.Context
import android.content.Intent
import com.aram.mehrabyan.gallery.api.GalleryLauncher
import com.aram.mehrabyan.gallery.impl.GalleryActivity

internal class GalleryLauncherImpl : GalleryLauncher {

    override fun launchGallery(context: Context) {
        context.startActivity(Intent(context, GalleryActivity::class.java))
    }
}