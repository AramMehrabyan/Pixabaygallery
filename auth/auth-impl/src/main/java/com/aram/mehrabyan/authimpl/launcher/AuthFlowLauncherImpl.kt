package com.aram.mehrabyan.authimpl.launcher

import android.content.Context
import android.content.Intent
import com.aram.mehrabyan.authapi.launcher.AuthFlowLauncher
import com.aram.mehrabyan.authimpl.AuthenticationActivity

internal class AuthFlowLauncherImpl: AuthFlowLauncher {

    override fun startAuthFlow(context: Context) {
        context.startActivity(Intent(context, AuthenticationActivity::class.java))
    }
}