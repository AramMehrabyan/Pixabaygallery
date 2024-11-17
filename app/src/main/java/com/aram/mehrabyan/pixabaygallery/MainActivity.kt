package com.aram.mehrabyan.pixabaygallery

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.aram.mehrabyan.authapi.launcher.AuthFlowLauncher
import com.aram.mehrabyan.authapi.domain.AuthenticationStateMockedProvider
import com.aram.mehrabyan.gallery.api.GalleryLauncher
import org.koin.android.ext.android.get
import org.koin.android.ext.android.inject

internal class MainActivity : AppCompatActivity() {

    private val authenticationStateMockedProvider: AuthenticationStateMockedProvider by inject()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        handleState()
    }

    private fun handleState() {
        when (authenticationStateMockedProvider.provide()) {
            AuthenticationStateMockedProvider.State.AUTHENTICATED -> {
                get<GalleryLauncher>().launchGallery(this)
            }
            AuthenticationStateMockedProvider.State.NON_AUTHENTICATED -> {
                get<AuthFlowLauncher>().startAuthFlow(this)
            }
        }
        finish()
    }
}