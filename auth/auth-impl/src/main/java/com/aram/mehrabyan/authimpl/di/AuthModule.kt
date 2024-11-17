package com.aram.mehrabyan.authimpl.di

import com.aram.mehrabyan.authapi.domain.AuthenticationStateMockedProvider
import com.aram.mehrabyan.authapi.launcher.AuthFlowLauncher
import com.aram.mehrabyan.authimpl.data.AuthMockedService
import com.aram.mehrabyan.authimpl.data.AuthMockedServiceImpl
import com.aram.mehrabyan.authimpl.domain.AuthenticationStateMockedProviderImpl
import com.aram.mehrabyan.authimpl.domain.authentication.RegisterUseCase
import com.aram.mehrabyan.authimpl.domain.authentication.RegisterUseCaseImpl
import com.aram.mehrabyan.authimpl.domain.authentication.SignInUseCase
import com.aram.mehrabyan.authimpl.domain.authentication.SignInUseCaseImpl
import com.aram.mehrabyan.authimpl.domain.verification.CredentialsVerifyManager
import com.aram.mehrabyan.authimpl.domain.verification.CredentialsVerifyManagerImpl
import com.aram.mehrabyan.authimpl.launcher.AuthFlowLauncherImpl
import com.aram.mehrabyan.authimpl.presentation.signin.SignInViewModel
import com.aram.mehrabyan.authimpl.presentation.signup.RegisterViewModel
import org.koin.core.module.dsl.viewModel
import org.koin.dsl.module

fun authModule() = module {

    single<AuthMockedService> {
        AuthMockedServiceImpl()
    }

    factory<AuthenticationStateMockedProvider> {
        AuthenticationStateMockedProviderImpl()
    }

    factory<CredentialsVerifyManager> {
        CredentialsVerifyManagerImpl()
    }

    factory<SignInUseCase> {
        SignInUseCaseImpl(service = get())
    }

    factory<RegisterUseCase> {
        RegisterUseCaseImpl(service = get())
    }

    factory<AuthFlowLauncher> {
        AuthFlowLauncherImpl()
    }

    viewModel {
        SignInViewModel(verifyManager = get(), signInUseCase = get())
    }

    viewModel {
        RegisterViewModel(verifyManager = get(), registerUseCase = get())
    }
}