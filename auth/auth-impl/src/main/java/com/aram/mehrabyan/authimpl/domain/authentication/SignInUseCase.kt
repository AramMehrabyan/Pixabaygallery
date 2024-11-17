package com.aram.mehrabyan.authimpl.domain.authentication

import com.aram.mehrabyan.authimpl.presentation.AuthState

internal interface SignInUseCase {

    fun signIn(email: String?, password: String?): AuthState
}