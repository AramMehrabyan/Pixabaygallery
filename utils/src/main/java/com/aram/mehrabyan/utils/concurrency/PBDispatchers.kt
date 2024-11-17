package com.aram.mehrabyan.utils.concurrency

import kotlinx.coroutines.CoroutineDispatcher

interface PBDispatchers {
    val ioDispatcher: CoroutineDispatcher
    val mainDispatcher: CoroutineDispatcher
    val defaultDispatcher: CoroutineDispatcher
}