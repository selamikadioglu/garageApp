package com.example.garage

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.garage.databinding.ActivityMainBinding
import com.example.garage.module.base.BaseActivity
import com.example.garage.module.base.BaseFragment
import com.example.garage.ui.DiscoverPage.DiscoverFragment

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

    }


    private fun replaceFragment(fragment: BaseFragment, addToBackStack: Boolean = false, tag: String? = null) {
        val transaction = fragmentTransaction().replace(R.id.mainContainer, fragment)
        if (addToBackStack){
            transaction.addToBackStack(tag)
        }
        transaction.commit()
    }
}