package com.aram.mehrabyan.authimpl.data

import com.aram.mehrabyan.authapi.domain.AuthenticationStateMockedProvider
import com.aram.mehrabyan.utils.model.ActionResult

internal class AuthMockedServiceImpl : AuthMockedService {

    override fun signIn(
        email: String,
        password: String
    ): ActionResult<AuthenticationStateMockedProvider.State> {
        return ActionResult.Success(AuthenticationStateMockedProvider.State.AUTHENTICATED)
    }

    override fun register(
        email: String,
        password: String,
        age: Int
    ): ActionResult<AuthenticationStateMockedProvider.State> {
        return ActionResult.Success(AuthenticationStateMockedProvider.State.AUTHENTICATED)
    }
}