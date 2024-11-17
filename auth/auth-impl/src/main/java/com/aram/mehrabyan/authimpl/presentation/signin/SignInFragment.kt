package com.aram.mehrabyan.authimpl.presentation.signin

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.aram.mehrabyan.authimpl.R
import com.aram.mehrabyan.authimpl.databinding.FragmentSignInBinding
import com.aram.mehrabyan.authimpl.presentation.signin.uibinder.SignInUiBinder
import org.koin.androidx.viewmodel.ext.android.viewModel

internal class SignInFragment : Fragment() {

    private val viewModel: SignInViewModel by viewModel()

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_sign_in, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val binding: FragmentSignInBinding = FragmentSignInBinding.bind(view)
        setupUi(binding)
    }

    private fun setupUi(binding: FragmentSignInBinding) {
        val uiBinder = SignInUiBinder(
            binding = binding,
            viewLifecycleOwner = viewLifecycleOwner
        )
        uiBinder.setup(fragment = this, viewModel = viewModel)
    }
}