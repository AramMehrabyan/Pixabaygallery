package com.aram.mehrabyan.authimpl.presentation.signin

import com.aram.mehrabyan.authimpl.domain.authentication.SignInUseCase
import com.aram.mehrabyan.authimpl.domain.verification.CredentialsVerifyManager
import com.aram.mehrabyan.authimpl.presentation.base.AuthViewModel

internal class SignInViewModel(
    private val signInUseCase: SignInUseCase,
    verifyManager: CredentialsVerifyManager
) : AuthViewModel(verifyManager) {

    fun signIn() {
        authStateFlow.value = signInUseCase.signIn(
            email = getEmailValue(),
            password = getPasswordValue()
        )
    }
}
