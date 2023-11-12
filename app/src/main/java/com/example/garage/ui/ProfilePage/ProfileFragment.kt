package com.example.garage.ui.ProfilePage

import com.example.garage.R
import com.example.garage.databinding.FragmentProfileBinding
import com.example.garage.module.base.BaseBindableFragment
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class ProfileFragment : BaseBindableFragment<FragmentProfileBinding, ProfileViewModel>() {

    companion object {
        fun newInstance() = ProfileFragment()
    }

    override fun targetViewModel() = ProfileViewModel::class.java
    override fun getLayoutResource() = R.layout.fragment_profile

    override fun onViewReady() {

    }


}