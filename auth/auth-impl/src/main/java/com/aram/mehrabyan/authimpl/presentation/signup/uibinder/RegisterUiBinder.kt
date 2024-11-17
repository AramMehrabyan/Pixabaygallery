package com.aram.mehrabyan.authimpl.presentation.signup.uibinder

import android.os.Build
import androidx.core.content.res.ResourcesCompat
import androidx.fragment.app.Fragment
import androidx.lifecycle.LifecycleOwner
import com.aram.mehrabyan.authimpl.R
import com.aram.mehrabyan.authimpl.databinding.FragmentRegisterBinding
import com.aram.mehrabyan.authimpl.presentation.base.AuthUiBinder
import com.aram.mehrabyan.authimpl.presentation.signup.RegisterViewModel

internal class RegisterUiBinder(
    private val binding: FragmentRegisterBinding,
    viewLifecycleOwner: LifecycleOwner
) : AuthUiBinder(viewLifecycleOwner) {

    fun setup(fragment: Fragment, viewModel: RegisterViewModel) {
        setupAgeNumberPicker()
        observeEmailTextChanges(
            viewModel = viewModel,
            emailInput = binding.etEmailInput,
            emailInputLayout = binding.emailInputLayout,
            actionButton = binding.btnRegister
        )
        observePasswordTextChanges(
            viewModel = viewModel,
            passwordInput = binding.etPasswordInput,
            passwordInputLayout = binding.passwordInputLayout,
            actionButton = binding.btnRegister
        )
        setupRegisterAction(viewModel = viewModel)
        observeAuthAction(viewModel = viewModel, fragment = fragment)
    }

    private fun setupAgeNumberPicker() {
        with(binding.ageNumberPicker) {
            maxValue = MAX_AGE
            minValue = MIN_AGE
            value = MIN_AGE
            if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.Q) {
                textColor = ResourcesCompat.getColor(
                    binding.root.resources,
                    R.color.input_color,
                    null
                )
            }
        }
    }

    private fun setupRegisterAction(viewModel: RegisterViewModel) {
        binding.btnRegister.setOnClickListener {
            viewModel.register(binding.ageNumberPicker.value)
        }
    }

    companion object {
        private const val MAX_AGE = 99
        private const val MIN_AGE = 18
    }
}