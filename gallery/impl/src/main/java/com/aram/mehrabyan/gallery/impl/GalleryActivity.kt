package com.aram.mehrabyan.gallery.impl

import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.aram.mehrabyan.gallery.impl.photos.PhotosFragment

class GalleryActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_gallery)

        supportFragmentManager.beginTransaction().replace(
            R.id.main_container,
            PhotosFragment(),
            "TAG"
        ).commit()
    }
}