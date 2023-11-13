package com.example.garage

import android.os.Bundle
import com.example.garage.databinding.ActivityMainBinding
import com.example.garage.module.base.BaseActivity
import com.example.garage.ui.CarPage.CarFragment
import com.example.garage.ui.DiscoverPage.DiscoverFragment
import com.example.garage.ui.LoginPage.LoginActivity
import com.example.garage.ui.ProfilePage.ProfileFragment
import com.example.garage.utils.SharedPreferencesManager
import javax.inject.Inject

class MainActivity : BaseActivity() {

    @Inject
    lateinit var sharedPreferencesManager: SharedPreferencesManager

    private lateinit var binding: ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        sharedPreferencesManager = SharedPreferencesManager(this)
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
                R.id.home -> {
                    replaceFragment(DiscoverFragment.newInstance())
                    true
                }
                R.id.cars -> {
                    replaceFragment(CarFragment.newInstance())
                    true
                }
                R.id.profile -> {
                    profileController()
                    false
                }
                else -> {
                    false
                }
            }
        }
    }

    private fun profileController() {
        if (sharedPreferencesManager.getToken().isNullOrEmpty()) {
            binding.bottomNav.selectedItemId = R.id.home
            openLoginPage()
        } else {
            binding.bottomNav.getMenu().findItem(R.id.profile).setChecked(true);
            replaceFragment(ProfileFragment.newInstance(), false)
        }
    }

    fun openLoginPage() {
        startActivity(
            LoginActivity.newIntent(
                this
            )
        )
    }


}