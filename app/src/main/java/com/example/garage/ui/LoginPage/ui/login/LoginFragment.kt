package com.example.garage.ui.LoginPage.ui.login

import com.example.garage.R
import com.example.garage.databinding.FragmentLoginPageBinding
import com.example.garage.module.base.BaseBindableFragment
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class LoginFragment : BaseBindableFragment<FragmentLoginPageBinding , LoginViewModel>() {

    companion object {
        fun newInstance() = LoginFragment()
    }

    override fun targetViewModel() = LoginViewModel::class.java

    override fun getLayoutResource() = R.layout.fragment_login_page

    override fun onViewReady() {
    }

}