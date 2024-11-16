package com.aram.mehrabyan.authimpl.di

import com.aram.mehrabyan.authapi.launcher.AuthFlowLauncher
import com.aram.mehrabyan.authimpl.launcher.AuthFlowLauncherImpl
import org.koin.dsl.module

fun authModule() = module {

    factory<AuthFlowLauncher> {
        AuthFlowLauncherImpl()
    }
}