package com.aram.mehrabyan.gallery.impl.presentation.photos.uibinder

import androidx.lifecycle.LifecycleOwner
import androidx.lifecycle.lifecycleScope
import androidx.recyclerview.widget.GridLayoutManager
import com.aram.mehrabyan.gallery.impl.R
import com.aram.mehrabyan.gallery.impl.databinding.FragmentPhotosBinding
import com.aram.mehrabyan.gallery.impl.presentation.photos.PhotosState
import com.aram.mehrabyan.gallery.impl.presentation.photos.adapter.PhotosAdapter
import com.aram.mehrabyan.utils.model.UiState
import com.aram.mehrabyan.utils.ui.gone
import com.aram.mehrabyan.utils.ui.show
import com.aram.mehrabyan.utils.ui.showToast
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.launchIn
import kotlinx.coroutines.flow.onEach

internal class PhotosUiBinder(
    private val binding: FragmentPhotosBinding,
    private val viewLifecycleOwner: LifecycleOwner,
    loadMore: (() -> Unit)?
) {

    private val photosAdapter: PhotosAdapter by lazy(LazyThreadSafetyMode.NONE) {
        PhotosAdapter(loadMore = loadMore)
    }

    init {
        initAdapter()
    }

    fun setup(stateFlow: StateFlow<UiState<PhotosState>>) {
        subscribeToUiStat(stateFlow)
    }

    private fun subscribeToUiStat(stateFlow: StateFlow<UiState<PhotosState>>) {
        stateFlow.onEach { state ->
            when (state) {
                is UiState.Loading -> {
                    showLoading(state)
                }
                is UiState.Error -> {
                    hideLoading()
                    showToastMessage()
                }
                is UiState.Success -> {
                    hideLoading()
                    photosAdapter.submitList(state.data.items)
                }
                else -> Unit
            }
        }.launchIn(viewLifecycleOwner.lifecycleScope)
    }

    private fun showLoading(state: UiState.Loading<*>) {
        if (state.isInitial) {
            binding.centerProgress.show()
        } else {
            binding.bottomProgress.show()
        }
    }

    private fun hideLoading() {
        binding.centerProgress.gone()
        binding.bottomProgress.gone()
    }

    private fun showToastMessage() {
        showToast(
            context = binding.root.context,
            message = binding.root.resources.getString(R.string.error_message)
        )
    }

    private fun initAdapter() {
        with(binding.rvPhotos) {
            layoutManager = GridLayoutManager(binding.root.context, 2)
            adapter = photosAdapter
        }
    }
}