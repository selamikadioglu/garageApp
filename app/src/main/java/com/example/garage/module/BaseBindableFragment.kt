package com.example.garage.module

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.databinding.DataBindingUtil
import androidx.databinding.ViewDataBinding
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider

abstract class BaseBindableFragment<VB : ViewDataBinding, VM : ViewModel> : BaseFragment() {

    protected lateinit var viewModel: VM
    protected lateinit var binding: VB

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        viewModel = ViewModelProvider(this)[targetViewModel()]
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = DataBindingUtil.inflate(inflater, getLayoutResource(), container, false)
        binding.lifecycleOwner = viewLifecycleOwner
        onViewReady()
        return binding.root
    }

    abstract fun targetViewModel(): Class<VM>

    abstract fun getLayoutResource(): Int

    abstract fun onViewReady()


    fun showToast(message: String? = "Test") {
        context?.let {
            Toast.makeText(it, message, Toast.LENGTH_LONG).show()
        }

    }
    fun popBackFragment() {
        val fragmentMng = requireActivity().supportFragmentManager
        fragmentMng.popBackStack()
    }
}