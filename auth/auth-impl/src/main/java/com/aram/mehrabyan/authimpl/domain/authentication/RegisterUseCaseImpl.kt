package com.aram.mehrabyan.authimpl.domain.authentication

import com.aram.mehrabyan.authapi.domain.AuthenticationStateMockedProvider
import com.aram.mehrabyan.authimpl.data.AuthMockedService
import com.aram.mehrabyan.authimpl.presentation.AuthState
import com.aram.mehrabyan.utils.model.ActionResult

internal class RegisterUseCaseImpl(
    private val service: AuthMockedService
) : RegisterUseCase {

    override fun register(email: String?, password: String?, age: Int): AuthState {
        return if (email.isNullOrBlank() || password.isNullOrBlank()) {
            AuthState.Error
        } else {
            when (val result = service.register(email = email, password = password, age = age)) {
                is ActionResult.Success -> {
                    handleAuthenticationState(result.data)
                }
                is ActionResult.Error -> {
                    AuthState.Error
                }
            }
        }
    }

    private fun handleAuthenticationState(state: AuthenticationStateMockedProvider.State): AuthState {
        return when (state) {
            AuthenticationStateMockedProvider.State.AUTHENTICATED -> {
                AuthState.Authenticated
            }
            AuthenticationStateMockedProvider.State.NON_AUTHENTICATED -> {
                AuthState.NonAuthenticated
            }
        }
    }
}