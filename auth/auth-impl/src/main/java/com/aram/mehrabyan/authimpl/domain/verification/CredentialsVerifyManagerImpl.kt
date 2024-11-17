package com.aram.mehrabyan.authimpl.domain.verification

import android.util.Patterns
import com.aram.mehrabyan.authimpl.R
import com.aram.mehrabyan.authimpl.presentation.VerificationState

internal class CredentialsVerifyManagerImpl : CredentialsVerifyManager {

    override fun verifyEmail(input: String?): VerificationState {
        return when {
            input.isNullOrEmpty() -> {
                VerificationState.Empty
            }
            !Patterns.EMAIL_ADDRESS.matcher(input.trim()).matches() -> {
                VerificationState.NotVerified(R.string.not_valid_email_info)
            }
            else -> {
                VerificationState.Verified(input)
            }
        }
    }

    override fun verifyPassword(input: String?): VerificationState {
        return when {
            input.isNullOrBlank() -> {
                VerificationState.Empty
            }
            input.trim().length < MIN_PASSWORD_LENGTH -> {
                VerificationState.NotVerified(R.string.short_password_info)
            }
            input.trim().length > MAX_PASSWORD_LENGTH -> {
                VerificationState.NotVerified(R.string.long_password_info)
            }
            else -> {
                VerificationState.Verified(input)
            }
        }
    }

    companion object {
        private const val MIN_PASSWORD_LENGTH = 6
        private const val MAX_PASSWORD_LENGTH = 12
    }
}