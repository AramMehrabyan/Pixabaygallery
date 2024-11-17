package com.aram.mehrabyan.gallery.impl.presentation.photos

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.aram.mehrabyan.gallery.impl.domain.photos.PhotosUseCase
import com.aram.mehrabyan.utils.model.ActionResult
import com.aram.mehrabyan.utils.model.UiState
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch

internal class PhotosViewModel(
    private val photosUseCase: PhotosUseCase
) : ViewModel() {

    private val _state: MutableStateFlow<UiState<PhotosState>> = MutableStateFlow(UiState.Initial)
    val state: StateFlow<UiState<PhotosState>>
        get() = _state

    init {
        loadInitialData()
    }

    fun loadMore() {
        (_state.value as? UiState.Success)?.let { currentState ->
            _state.value = UiState.Loading(isInitial = false, data = currentState.data)
            handleContentLoading(
                page = currentState.data.currentPage.inc(),
                currentStateData = currentState.data
            )
        }
    }

    private fun loadInitialData() {
        _state.value = UiState.Loading(isInitial = true)
        handleContentLoading(page = PhotosState.INITIAL_PAGE)
    }

    private fun handleContentLoading(page: Int, currentStateData: PhotosState? = null) {
        viewModelScope.launch {
            when (val result = photosUseCase.getPhotos(page)) {
                is ActionResult.Success -> {
                    handleSuccessResult(data = result.data, currentStateData = currentStateData)
                }
                is ActionResult.Error -> {
                    _state.value = UiState.Error(result.exception)
                }
            }
        }
    }

    private fun handleSuccessResult(data: PhotosState, currentStateData: PhotosState?) {
        if (currentStateData != null) {
            _state.value = UiState.Success(
                data = currentStateData.copy(
                    currentPage = data.currentPage,
                    items = currentStateData.items.toMutableList() + data.items
                )
            )
        } else {
            _state.value = UiState.Success(data)
        }
    }
}