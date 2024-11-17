package com.aram.mehrabyan.authimpl.presentation.signin.uibinder

import androidx.core.widget.addTextChangedListener
import androidx.fragment.app.Fragment
import androidx.lifecycle.LifecycleOwner
import androidx.lifecycle.lifecycleScope
import com.aram.mehrabyan.authimpl.R
import com.aram.mehrabyan.authimpl.databinding.FragmentSignInBinding
import com.aram.mehrabyan.authimpl.presentation.AuthState
import com.aram.mehrabyan.authimpl.presentation.VerificationState
import com.aram.mehrabyan.authimpl.presentation.signin.SignInViewModel
import com.aram.mehrabyan.gallery.api.GalleryLauncher
import com.aram.mehrabyan.utils.ui.showToast
import com.google.android.material.textfield.TextInputLayout
import kotlinx.coroutines.flow.launchIn
import kotlinx.coroutines.flow.onEach
import org.koin.android.ext.android.get

internal class SignInUiBinder(
    private val binding: FragmentSignInBinding,
    private val viewLifecycleOwner: LifecycleOwner
) {

    fun setup(fragment: Fragment, viewModel: SignInViewModel) {
        observeEmailTextChanges(viewModel)
        observePasswordTextChanges(viewModel)
        setupSignInAction(fragment = fragment, viewModel = viewModel)
    }

    private fun setupSignInAction(fragment: Fragment, viewModel: SignInViewModel) {
        binding.btnSignIn.setOnClickListener {
            viewModel.signIn()
        }
        viewModel.authState.onEach { state ->
            handleAuthState(state = state, fragment = fragment)
        }.launchIn(viewLifecycleOwner.lifecycleScope)
    }

    private fun observeEmailTextChanges(viewModel: SignInViewModel) {
        binding.etEmailInput.addTextChangedListener { editable ->
            viewModel.verifyEmail(editable?.toString())
        }
        viewModel.emailVerificationState.onEach { state ->
            handleStateWithInputLayout(state = state, layout = binding.emailInputLayout)
            handleActionButtonState(
                emailVerificationState = state,
                passwordVerificationState = viewModel.passwordVerificationState.value
            )
        }.launchIn(viewLifecycleOwner.lifecycleScope)
    }

    private fun observePasswordTextChanges(viewModel: SignInViewModel) {
        binding.etPasswordInput.addTextChangedListener { editable ->
            viewModel.verifyPassword(editable?.toString())
        }
        viewModel.passwordVerificationState.onEach { state ->
            handleStateWithInputLayout(state = state, layout = binding.passwordInputLayout)
            handleActionButtonState(
                emailVerificationState = viewModel.emailVerificationState.value,
                passwordVerificationState = state
            )
        }.launchIn(viewLifecycleOwner.lifecycleScope)
    }

    private fun handleStateWithInputLayout(state: VerificationState, layout: TextInputLayout) {
        when (state) {
            is VerificationState.NotVerified -> {
                layout.error = binding.root.resources.getString(state.errorMessageRes)
            }
            else -> {
                layout.error = null
            }
        }
    }

    private fun handleAuthState(state: AuthState, fragment: Fragment) {
        when (state) {
            AuthState.Authenticated -> {
                launchGallery(fragment)
            }
            AuthState.Error -> {
                showToastMessage()
            }
            else -> Unit
        }
    }

    private fun handleActionButtonState(
        emailVerificationState: VerificationState,
        passwordVerificationState: VerificationState,
    ) {
        val isEnabled = emailVerificationState is VerificationState.Verified
                && passwordVerificationState is VerificationState.Verified
        binding.btnSignIn.isEnabled = isEnabled
        binding.btnSignIn.alpha = if (isEnabled) 1f else 0.5f
    }

    private fun showToastMessage(
        message: String = binding.root.resources.getString(R.string.error_message)
    ) {
        showToast(context = binding.root.context, message = message)
    }

    private fun launchGallery(fragment: Fragment) {
        fragment.activity?.takeIf { !it.isFinishing }?.let { activity ->
            fragment.get<GalleryLauncher>().launchGallery(activity)
            activity.finish()
        }
    }
}