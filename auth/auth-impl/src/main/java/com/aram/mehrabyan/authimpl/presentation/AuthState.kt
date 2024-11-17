package com.aram.mehrabyan.authimpl.presentation

internal sealed interface AuthState {
    data object Authenticated : AuthState
    data object NonAuthenticated : AuthState
    data object Error : AuthState
}
