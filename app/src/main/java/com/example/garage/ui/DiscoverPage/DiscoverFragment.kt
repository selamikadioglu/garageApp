package com.example.garage.ui.DiscoverPage

import androidx.lifecycle.ViewModelProvider
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.garage.R
import com.example.garage.databinding.FragmentDiscoverBinding
import com.example.garage.module.base.BaseBindableFragment

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