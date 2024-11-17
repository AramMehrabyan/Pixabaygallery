package com.aram.mehrabyan.utils.model

sealed interface UiState<out STATE> {
    data object Initial : UiState<Nothing>

    data class Loading<out DATA>(
        val isInitial: Boolean = false,
        val data: DATA? = null
    ) : UiState<DATA>

    data class Success<out DATA>(val data: DATA) : UiState<DATA>

    data class Error(val exception: Exception? = null) : UiState<Nothing>
}
