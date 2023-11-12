package com.example.garage

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.garage.databinding.ActivityMainBinding
import com.example.garage.module.base.BaseActivity
import com.example.garage.module.base.BaseFragment
import com.example.garage.ui.CarPage.CarFragment
import com.example.garage.ui.DiscoverPage.DiscoverFragment
import com.example.garage.ui.ProfilePage.ProfileFragment

class MainActivity : BaseActivity() {

    private lateinit var binding: ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        hideActionBar()
        replaceFragment(DiscoverFragment.newInstance())
        setupView()
    }

    private fun setupView() {
        navigationBarClickControl()
    }

    private fun navigationBarClickControl() {
        binding.bottomNav.setOnItemSelectedListener {
            when (it.itemId) {
                R.id.home -> replaceFragment(DiscoverFragment.newInstance())
                R.id.cars -> replaceFragment(CarFragment.newInstance())
                R.id.profile -> replaceFragment(ProfileFragment.newInstance())
                else -> {}

            }
            true
        }
    }



}