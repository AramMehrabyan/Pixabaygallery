package com.aram.mehrabyan.gallery.impl.presentation.photodetail

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.os.bundleOf
import androidx.fragment.app.Fragment
import com.aram.mehrabyan.gallery.impl.R
import com.aram.mehrabyan.gallery.impl.databinding.FragmentPhotoDetailBinding
import com.aram.mehrabyan.gallery.impl.presentation.photodetail.uibinder.PhotoDetailsUiBinder
import org.koin.androidx.viewmodel.ext.android.viewModel
import org.koin.core.parameter.parametersOf

internal class PhotoDetailFragment : Fragment() {

    private val viewModel: PhotoDetailViewModel by viewModel {
        parametersOf(arguments?.getLong(KEY_ID))
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_photo_detail, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val binding = FragmentPhotoDetailBinding.bind(view)
        initUi(binding)
    }

    private fun initUi(binding: FragmentPhotoDetailBinding) {
        val uiBinder = PhotoDetailsUiBinder(
            binding = binding,
            viewLifecycleOwner = viewLifecycleOwner
        )
        uiBinder.setup(viewModel.state)
    }

    companion object {
        private const val KEY_ID = "PhotoDetailFragment.ID"

        fun createArguments(id: Long): Bundle {
            return bundleOf(KEY_ID to id)
        }
    }
}