package com.aram.mehrabyan.authimpl.presentation.signup

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.aram.mehrabyan.authimpl.R
import com.aram.mehrabyan.authimpl.databinding.FragmentRegisterBinding
import com.aram.mehrabyan.authimpl.presentation.signup.uibinder.RegisterUiBinder
import org.koin.androidx.viewmodel.ext.android.viewModel

internal class RegisterFragment : Fragment() {

    private val viewModel: RegisterViewModel by viewModel()

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_register, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        setupUi(FragmentRegisterBinding.bind(view))
    }

    private fun setupUi(binding: FragmentRegisterBinding) {
        val uiBinder = RegisterUiBinder(
            binding = binding,
            viewLifecycleOwner = viewLifecycleOwner
        )
        uiBinder.setup(fragment = this, viewModel = viewModel)
    }
}