package com.aram.mehrabyan.gallery.impl.presentation.photodetail.uibinder

import androidx.lifecycle.LifecycleOwner
import androidx.lifecycle.lifecycleScope
import com.aram.mehrabyan.gallery.impl.databinding.FragmentPhotoDetailBinding
import com.aram.mehrabyan.gallery.impl.presentation.photodetail.PhotoDetailUiState
import com.aram.mehrabyan.utils.imaheloader.load
import com.aram.mehrabyan.utils.model.UiState
import com.aram.mehrabyan.utils.ui.gone
import com.aram.mehrabyan.utils.ui.show
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.launchIn
import kotlinx.coroutines.flow.onEach

internal class PhotoDetailsUiBinder(
    private val binding: FragmentPhotoDetailBinding,
    private val viewLifecycleOwner: LifecycleOwner
) {

    fun setup(stateFlow: StateFlow<UiState<PhotoDetailUiState>>) {
        subscribeToUiStat(stateFlow)
    }

    private fun subscribeToUiStat(stateFlow: StateFlow<UiState<PhotoDetailUiState>>) {
        stateFlow.onEach { state ->
            when (state) {
                is UiState.Loading -> {
                    showLoading()
                }
                is UiState.Error -> {
                    hideLoading()
                    showErrorMessage()
                }
                is UiState.Success -> {
                    hideLoading()
                    bindUiState(state.data)
                }
                else -> Unit
            }
        }.launchIn(viewLifecycleOwner.lifecycleScope)
    }

    private fun bindUiState(data: PhotoDetailUiState) {
        binding.imgDetail.load(data.largeImageURL)
        binding.tvImageSizeInfo.text = "${data.imageSize}"
        binding.tvImageTypeInfo.text = data.type
        binding.tvImageTagsInfo.text = data.tags
        binding.tvImageUserNameInfo.text = data.userName
        binding.tvImageViewsInfo.text = "${data.viewsCount}"
        binding.tvImageLikesInfo.text = "${data.likesCount}"
        binding.tvImageCommentsInfo.text = "${data.commentsCount}"
        binding.tvImageFavoritesInfo.text = "${data.favoritesCount}"
        binding.tvImageDownloadsInfo.text = "${data.downloadsCount}"
    }

    private fun showLoading() {
        binding.centerProgress.show()
    }

    private fun hideLoading() {
        binding.centerProgress.gone()
    }

    private fun showErrorMessage() {
        binding.tvErrorInfo.show()
    }

}