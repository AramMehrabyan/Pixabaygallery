package com.aram.mehrabyan.authapi.domain

interface AuthenticationStateMockedProvider {

    fun provide(): State

    enum class State {
        AUTHENTICATED,
        NON_AUTHENTICATED
    }
}