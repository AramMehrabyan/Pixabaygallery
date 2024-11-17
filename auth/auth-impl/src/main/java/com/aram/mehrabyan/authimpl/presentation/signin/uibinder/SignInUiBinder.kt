package com.aram.mehrabyan.authimpl.presentation.signin.uibinder

import androidx.fragment.app.Fragment
import androidx.lifecycle.LifecycleOwner
import androidx.navigation.fragment.findNavController
import com.aram.mehrabyan.authimpl.R
import com.aram.mehrabyan.authimpl.databinding.FragmentSignInBinding
import com.aram.mehrabyan.authimpl.presentation.base.AuthUiBinder
import com.aram.mehrabyan.authimpl.presentation.signin.SignInViewModel

internal class SignInUiBinder(
    private val binding: FragmentSignInBinding,
    viewLifecycleOwner: LifecycleOwner
) : AuthUiBinder(viewLifecycleOwner) {

    fun setup(fragment: Fragment, viewModel: SignInViewModel) {
        observeEmailTextChanges(
            viewModel = viewModel,
            emailInput = binding.etEmailInput,
            emailInputLayout = binding.emailInputLayout,
            actionButton = binding.btnSignIn
        )
        observePasswordTextChanges(
            viewModel = viewModel,
            passwordInput = binding.etPasswordInput,
            passwordInputLayout = binding.passwordInputLayout,
            actionButton = binding.btnSignIn
        )
        setupSignInAction(viewModel = viewModel)
        observeAuthAction(viewModel = viewModel, fragment = fragment)
        setupRegisterAction(fragment = fragment)
    }

    private fun setupSignInAction(viewModel: SignInViewModel) {
        binding.btnSignIn.setOnClickListener {
            viewModel.signIn()
        }
    }

    private fun setupRegisterAction(fragment: Fragment) {
        binding.btnOpenRegister.setOnClickListener {
            fragment.findNavController().navigate(R.id.register)
        }
    }
}