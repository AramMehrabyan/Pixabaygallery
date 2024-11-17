package com.aram.mehrabyan.authimpl.presentation.base

import androidx.lifecycle.ViewModel
import com.aram.mehrabyan.authimpl.domain.verification.CredentialsVerifyManager
import com.aram.mehrabyan.authimpl.presentation.AuthState
import com.aram.mehrabyan.authimpl.presentation.VerificationState
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow

internal abstract class AuthViewModel(
    private val verifyManager: CredentialsVerifyManager
) : ViewModel() {

    private val _emailVerificationState: MutableStateFlow<VerificationState> =
        MutableStateFlow(VerificationState.Empty)
    val emailVerificationState: StateFlow<VerificationState>
        get() = _emailVerificationState
    private val _passwordVerificationState: MutableStateFlow<VerificationState> =
        MutableStateFlow(VerificationState.Empty)
    val passwordVerificationState: StateFlow<VerificationState>
        get() = _passwordVerificationState

    protected val authStateFlow: MutableStateFlow<AuthState> =
        MutableStateFlow(AuthState.NonAuthenticated)
    val authState: StateFlow<AuthState>
        get() = authStateFlow

    fun verifyEmail(input: String?) {
        _emailVerificationState.value = verifyManager.verifyEmail(input)
    }

    fun verifyPassword(input: String?) {
        _passwordVerificationState.value = verifyManager.verifyPassword(input)
    }

    protected fun getEmailValue(): String? {
        return (_emailVerificationState.value as? VerificationState.Verified)?.input
    }

    protected fun getPasswordValue(): String? {
        return (_passwordVerificationState.value as? VerificationState.Verified)?.input
    }
}