package com.aram.mehrabyan.authimpl.presentation.base

import android.content.Context
import androidx.appcompat.widget.AppCompatButton
import androidx.core.widget.addTextChangedListener
import androidx.fragment.app.Fragment
import androidx.lifecycle.LifecycleOwner
import androidx.lifecycle.lifecycleScope
import com.aram.mehrabyan.authimpl.R
import com.aram.mehrabyan.authimpl.presentation.AuthState
import com.aram.mehrabyan.authimpl.presentation.VerificationState
import com.aram.mehrabyan.gallery.api.GalleryLauncher
import com.aram.mehrabyan.utils.ui.showToast
import com.google.android.material.textfield.TextInputEditText
import com.google.android.material.textfield.TextInputLayout
import kotlinx.coroutines.flow.launchIn
import kotlinx.coroutines.flow.onEach
import org.koin.android.ext.android.get

internal open class AuthUiBinder(
    private val viewLifecycleOwner: LifecycleOwner
) {

    protected fun observeAuthAction(viewModel: AuthViewModel, fragment: Fragment) {
        viewModel.authState.onEach { state ->
            handleAuthState(state = state, fragment = fragment)
        }.launchIn(viewLifecycleOwner.lifecycleScope)
    }

    protected fun observeEmailTextChanges(
        viewModel: AuthViewModel,
        emailInput: TextInputEditText,
        emailInputLayout: TextInputLayout,
        actionButton: AppCompatButton
    ) {
        emailInput.addTextChangedListener { editable ->
            viewModel.verifyEmail(editable?.toString())
        }
        viewModel.emailVerificationState.onEach { state ->
            handleStateWithInputLayout(state = state, layout = emailInputLayout)
            handleActionButtonState(
                emailVerificationState = state,
                passwordVerificationState = viewModel.passwordVerificationState.value,
                actionButton = actionButton
            )
        }.launchIn(viewLifecycleOwner.lifecycleScope)
    }

    protected fun observePasswordTextChanges(
        viewModel: AuthViewModel,
        passwordInput: TextInputEditText,
        passwordInputLayout: TextInputLayout,
        actionButton: AppCompatButton
    ) {
        passwordInput.addTextChangedListener { editable ->
            viewModel.verifyPassword(editable?.toString())
        }
        viewModel.passwordVerificationState.onEach { state ->
            handleStateWithInputLayout(state = state, layout = passwordInputLayout)
            handleActionButtonState(
                emailVerificationState = viewModel.emailVerificationState.value,
                passwordVerificationState = state,
                actionButton = actionButton
            )
        }.launchIn(viewLifecycleOwner.lifecycleScope)
    }

    private fun handleStateWithInputLayout(state: VerificationState, layout: TextInputLayout) {
        when (state) {
            is VerificationState.NotVerified -> {
                layout.error = layout.resources.getString(state.errorMessageRes)
            }
            else -> {
                layout.error = null
            }
        }
    }

    private fun handleActionButtonState(
        emailVerificationState: VerificationState,
        passwordVerificationState: VerificationState,
        actionButton: AppCompatButton
    ) {
        val isEnabled = emailVerificationState is VerificationState.Verified
                && passwordVerificationState is VerificationState.Verified
        actionButton.isEnabled = isEnabled
        actionButton.alpha = if (isEnabled) 1f else 0.5f
    }

    private fun handleAuthState(state: AuthState, fragment: Fragment) {
        when (state) {
            AuthState.Authenticated -> {
                launchGallery(fragment)
            }
            AuthState.Error -> {
                fragment.context?.let {
                    showToastMessage(
                        context = it,
                        message = fragment.resources.getString(R.string.error_message)
                    )
                }
            }
            else -> Unit
        }
    }

    private fun showToastMessage(context: Context, message: String) {
        showToast(context = context, message = message)
    }

    private fun launchGallery(fragment: Fragment) {
        fragment.activity?.takeIf { !it.isFinishing }?.let { activity ->
            fragment.get<GalleryLauncher>().launchGallery(activity)
            activity.finish()
        }
    }
}