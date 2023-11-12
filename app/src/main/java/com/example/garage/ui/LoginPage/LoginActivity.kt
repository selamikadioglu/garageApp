package com.example.garage.ui.LoginPage

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.garage.R
import com.example.garage.module.base.BaseActivity
import com.example.garage.ui.LoginPage.ui.login.LoginFragment

class LoginActivity : BaseActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)
        if (savedInstanceState == null) {
            supportFragmentManager.beginTransaction()
                .replace(R.id.container, LoginFragment.newInstance())
                .commitNow()
        }
    }
}