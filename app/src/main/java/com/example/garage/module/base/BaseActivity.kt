package com.example.garage.module.base

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.FragmentManager
import androidx.fragment.app.FragmentTransaction

open class BaseActivity : AppCompatActivity(){

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

    }
    fun hideActionBar() {
        supportActionBar?.hide()
    }
    fun closeActivity() {
        finish()
    }

    fun closeActivityByResult(key: String, requestCode: Int) {
        val data = Intent()
        data.putExtra("key", requestCode)
        setResult(RESULT_OK, data)
        finish()
    }

    protected fun fragmentManager(): FragmentManager {
        return supportFragmentManager
    }

    protected fun fragmentTransaction(): FragmentTransaction {
        return fragmentManager().beginTransaction()
    }
}