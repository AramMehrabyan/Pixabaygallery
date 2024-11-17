package com.aram.mehrabyan.gallery.impl.presentation.photos

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import com.aram.mehrabyan.gallery.impl.R
import com.aram.mehrabyan.gallery.impl.databinding.FragmentPhotosBinding
import com.aram.mehrabyan.gallery.impl.presentation.photodetail.PhotoDetailFragment
import com.aram.mehrabyan.gallery.impl.presentation.photos.uibinder.PhotosUiBinder
import org.koin.androidx.viewmodel.ext.android.viewModel

internal class PhotosFragment : Fragment() {

    private val viewModel: PhotosViewModel by viewModel()

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_photos, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        initUi(FragmentPhotosBinding.bind(view))
    }

    private fun initUi(binding: FragmentPhotosBinding) {
        val photosUiBinder = PhotosUiBinder(
            binding = binding,
            viewLifecycleOwner = viewLifecycleOwner,
            onItemClick = { id -> openPhotoDetails(id) },
            loadMore = { viewModel.loadMore() }
        )
        photosUiBinder.setup(stateFlow = viewModel.state)
    }

    private fun openPhotoDetails(id: Long) {
        findNavController().navigate(
            resId = R.id.open_details,
            args = PhotoDetailFragment.createArguments(id)
        )
    }
}