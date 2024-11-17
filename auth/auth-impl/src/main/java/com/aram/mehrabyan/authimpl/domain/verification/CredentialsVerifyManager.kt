package com.aram.mehrabyan.authimpl.domain.verification

import com.aram.mehrabyan.authimpl.presentation.VerificationState

internal interface CredentialsVerifyManager {

    fun verifyEmail(input: String?): VerificationState

    fun verifyPassword(input: String?): VerificationState
}