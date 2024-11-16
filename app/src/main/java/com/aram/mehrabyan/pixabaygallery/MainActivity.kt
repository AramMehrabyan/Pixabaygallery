package com.aram.mehrabyan.pixabaygallery

import android.os.Bundle
import android.widget.Button
import androidx.appcompat.app.AppCompatActivity
import com.aram.mehrabyan.gallery.api.GalleryLauncher
import org.koin.android.ext.android.inject

class MainActivity : AppCompatActivity() {

    private val galleryLauncher: GalleryLauncher by inject()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        findViewById<Button>(R.id.btn_auth).setOnClickListener {
            galleryLauncher.launchGallery(context = this)
            finish()
        }
    }
}