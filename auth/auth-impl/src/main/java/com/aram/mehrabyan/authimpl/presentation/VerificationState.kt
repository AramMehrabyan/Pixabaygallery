package com.aram.mehrabyan.authimpl.presentation

import androidx.annotation.StringRes

internal sealed interface VerificationState {

    data object Empty : VerificationState

    data class Verified(val input: String) : VerificationState

    data class NotVerified(@StringRes val errorMessageRes: Int) : VerificationState
}