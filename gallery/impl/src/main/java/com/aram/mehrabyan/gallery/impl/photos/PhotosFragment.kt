package com.aram.mehrabyan.gallery.impl.photos

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.lifecycleScope
import com.aram.mehrabyan.gallery.impl.R
import com.aram.mehrabyan.gallery.impl.data.GalleryService
import com.aram.mehrabyan.gallery.impl.databinding.FragmentPhotosBinding
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext
import org.koin.android.ext.android.inject

internal class PhotosFragment : Fragment() {

    private val service: GalleryService by inject()

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_photos, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val binding: FragmentPhotosBinding = FragmentPhotosBinding.bind(view)

        viewLifecycleOwner.lifecycleScope.launch(Dispatchers.Main) {
            binding.tvTestInfo.text = getGalleryJsonString()
        }
    }

    private suspend fun getGalleryJsonString(): String {
        return withContext(Dispatchers.IO) {
            val result = service.getPhotos(
                key = "47117783-c7ad79934807599452c45f289",
                page = 1
            )
            result.body()?.toString() ?: ""
        }
    }
}