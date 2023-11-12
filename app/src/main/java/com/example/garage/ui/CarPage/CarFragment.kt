package com.example.garage.ui.CarPage

import androidx.lifecycle.ViewModelProvider
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.garage.R
import com.example.garage.databinding.FragmentCarBinding
import com.example.garage.module.base.BaseBindableFragment
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class CarFragment : BaseBindableFragment<FragmentCarBinding, CarViewModel>() {

    companion object {
        fun newInstance() = CarFragment()
    }

    override fun targetViewModel() = CarViewModel::class.java

    override fun getLayoutResource() = R.layout.fragment_car

    override fun onViewReady() {

    }


}