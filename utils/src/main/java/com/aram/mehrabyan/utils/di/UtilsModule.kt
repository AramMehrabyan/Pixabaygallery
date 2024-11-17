package com.aram.mehrabyan.utils.di

import com.aram.mehrabyan.utils.concurrency.PBDispatchers
import com.aram.mehrabyan.utils.concurrency.PBDispatchersImpl
import org.koin.dsl.module

fun utilsModule() = module {

    single<PBDispatchers> {
        PBDispatchersImpl()
    }
}