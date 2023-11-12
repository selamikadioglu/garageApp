package com.example.garage.ui.DiscoverPage

import com.example.garage.R
import com.example.garage.databinding.FragmentDiscoverBinding
import com.example.garage.module.base.BaseBindableFragment
import dagger.hilt.android.AndroidEntryPoint

class DiscoverFragment : BaseBindableFragment<FragmentDiscoverBinding, DiscoverViewModel>() {

    companion object {
        fun newInstance() = DiscoverFragment()
    }

    override fun targetViewModel() = DiscoverViewModel::class.java

    override fun getLayoutResource() = R.layout.fragment_discover

    override fun onViewReady() {
        showToast("Discover Page")
    }


}