package com.aram.mehrabyan.authapi.launcher

import android.content.Context

interface AuthFlowLauncher {

    fun startAuthFlow(context: Context)
}