package com.example.garage.ui.CarPage

import com.example.garage.R
import com.example.garage.databinding.FragmentCarBinding
import com.example.garage.module.base.BaseBindableFragment

class CarFragment : BaseBindableFragment<FragmentCarBinding, CarViewModel>() {

    companion object {
        fun newInstance() = CarFragment()
    }

    override fun targetViewModel() = CarViewModel::class.java

    override fun getLayoutResource() = R.layout.fragment_car

    override fun onViewReady() {

    }


}