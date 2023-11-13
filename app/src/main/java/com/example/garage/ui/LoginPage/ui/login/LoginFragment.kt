package com.example.garage.ui.LoginPage.ui.login

import com.example.garage.R
import com.example.garage.databinding.FragmentLoginPageBinding
import com.example.garage.module.base.BaseBindableFragment
import com.example.garage.ui.LoginPage.ui.login.state.LoginPageClickActions
import com.example.garage.utils.collectFlow
import dagger.hilt.android.AndroidEntryPoint

class LoginFragment : BaseBindableFragment<FragmentLoginPageBinding , LoginViewModel>() {

    companion object {
        fun newInstance() = LoginFragment()
    }

    override fun targetViewModel() = LoginViewModel::class.java

    override fun getLayoutResource() = R.layout.fragment_login_page

    override fun onViewReady() {
        clicks()
        observeData()
    }

    private fun clicks() {
        binding.closeButton.setOnClickListener {
            viewModel.onCloseButtonClickListener()
        }
    }

    private fun observeData() {
        collectFlow(viewModel.clickActions) {
            handleClickActions(it)
        }
    }

    private fun handleClickActions(viewClickState: LoginPageClickActions) {
        when(viewClickState){
            LoginPageClickActions.CloseButtonAction -> {
                requireActivity().finish()
            }
            else -> {

            }
        }
    }

}