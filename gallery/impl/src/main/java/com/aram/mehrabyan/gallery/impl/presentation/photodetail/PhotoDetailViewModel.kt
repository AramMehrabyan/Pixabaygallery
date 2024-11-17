package com.aram.mehrabyan.gallery.impl.presentation.photodetail

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.aram.mehrabyan.gallery.impl.domain.photodetail.PhotoDetailUseCase
import com.aram.mehrabyan.utils.model.ActionResult
import com.aram.mehrabyan.utils.model.UiState
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch

internal class PhotoDetailViewModel(
    private val id: Long,
    private val photoDetailUseCase: PhotoDetailUseCase
) : ViewModel() {

    private val _state: MutableStateFlow<UiState<PhotoDetailUiState>> =
        MutableStateFlow(UiState.Initial)
    val state: StateFlow<UiState<PhotoDetailUiState>>
        get() = _state

    init {
        loadPhotoDetails()
    }

    private fun loadPhotoDetails() {
        viewModelScope.launch {
            _state.value = UiState.Loading()

            when (val result = photoDetailUseCase.getPhotoDetails(id = id)) {
                is ActionResult.Success -> {
                    _state.value = UiState.Success(result.data)
                }
                is ActionResult.Error -> {
                    _state.value = UiState.Error(result.exception)
                }
            }
        }
    }
}