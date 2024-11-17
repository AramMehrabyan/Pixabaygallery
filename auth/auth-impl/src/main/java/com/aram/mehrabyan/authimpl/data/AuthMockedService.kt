package com.aram.mehrabyan.authimpl.data

import com.aram.mehrabyan.authapi.domain.AuthenticationStateMockedProvider
import com.aram.mehrabyan.utils.model.ActionResult

internal interface AuthMockedService {

    fun signIn(
        email: String,
        password: String
    ): ActionResult<AuthenticationStateMockedProvider.State>

    fun register(
        email: String,
        password: String,
        age: Int
    ): ActionResult<AuthenticationStateMockedProvider.State>
}