package com.aram.mehrabyan.authimpl.domain.authentication

import com.aram.mehrabyan.authapi.domain.AuthenticationStateMockedProvider
import com.aram.mehrabyan.authimpl.data.AuthMockedService
import com.aram.mehrabyan.authimpl.presentation.AuthState
import com.aram.mehrabyan.utils.model.ActionResult

internal class SignInUseCaseImpl(
    private val service: AuthMockedService
) : SignInUseCase {

    override fun signIn(email: String?, password: String?): AuthState {
        return if (email.isNullOrBlank() || password.isNullOrBlank()) {
            AuthState.Error
        } else {
            when (val result = service.signIn(email, password)) {
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