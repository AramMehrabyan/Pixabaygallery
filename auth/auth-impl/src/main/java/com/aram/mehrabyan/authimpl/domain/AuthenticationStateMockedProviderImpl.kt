package com.aram.mehrabyan.authimpl.domain

import com.aram.mehrabyan.authapi.domain.AuthenticationStateMockedProvider

internal class AuthenticationStateMockedProviderImpl : AuthenticationStateMockedProvider {

    override fun provide(): AuthenticationStateMockedProvider.State {
        return AuthenticationStateMockedProvider.State.NON_AUTHENTICATED
    }
}