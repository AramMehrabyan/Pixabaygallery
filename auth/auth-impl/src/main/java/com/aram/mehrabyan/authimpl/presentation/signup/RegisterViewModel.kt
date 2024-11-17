package com.aram.mehrabyan.authimpl.presentation.signup

import com.aram.mehrabyan.authimpl.domain.authentication.RegisterUseCase
import com.aram.mehrabyan.authimpl.domain.verification.CredentialsVerifyManager
import com.aram.mehrabyan.authimpl.presentation.base.AuthViewModel

internal class RegisterViewModel(
    private val registerUseCase: RegisterUseCase,
    verifyManager: CredentialsVerifyManager
) : AuthViewModel(verifyManager) {

    fun register(age: Int) {
        authStateFlow.value = registerUseCase.register(
            email = getEmailValue(),
            password = getPasswordValue(),
            age = age
        )
    }
}