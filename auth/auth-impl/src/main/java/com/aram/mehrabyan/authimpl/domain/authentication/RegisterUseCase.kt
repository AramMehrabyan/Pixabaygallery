package com.aram.mehrabyan.authimpl.domain.authentication

import com.aram.mehrabyan.authimpl.presentation.AuthState

internal interface RegisterUseCase {

    fun register(email: String?, password: String?, age: Int): AuthState
}