package com.aram.mehrabyan.authimpl.presentation.signin

import androidx.lifecycle.ViewModel
import com.aram.mehrabyan.authimpl.domain.authentication.SignInUseCase
import com.aram.mehrabyan.authimpl.domain.verification.CredentialsVerifyManager
import com.aram.mehrabyan.authimpl.presentation.AuthState
import com.aram.mehrabyan.authimpl.presentation.VerificationState
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow

internal class SignInViewModel(
    private val verifyManager: CredentialsVerifyManager,
    private val signInUseCase: SignInUseCase
) : ViewModel() {

    private val _emailVerificationState: MutableStateFlow<VerificationState> =
        MutableStateFlow(VerificationState.Empty)
    val emailVerificationState: StateFlow<VerificationState>
        get() = _emailVerificationState
    private val _passwordVerificationState: MutableStateFlow<VerificationState> =
        MutableStateFlow(VerificationState.Empty)
    val passwordVerificationState: StateFlow<VerificationState>
        get() = _passwordVerificationState

    private val _authState: MutableStateFlow<AuthState> =
        MutableStateFlow(AuthState.NonAuthenticated)
    val authState: StateFlow<AuthState>
        get() = _authState

    fun verifyEmail(input: String?) {
        _emailVerificationState.value = verifyManager.verifyEmail(input)
    }

    fun verifyPassword(input: String?) {
        _passwordVerificationState.value = verifyManager.verifyPassword(input)
    }

    fun signIn() {
        _authState.value = signInUseCase.signIn(
            email = (_emailVerificationState.value as? VerificationState.Verified)?.input,
            password = (_passwordVerificationState.value as? VerificationState.Verified)?.input
        )
    }
}
