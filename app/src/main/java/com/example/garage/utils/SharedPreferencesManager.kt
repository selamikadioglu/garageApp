package com.example.garage.utils

import android.content.Context
import android.content.SharedPreferences
import dagger.hilt.android.qualifiers.ApplicationContext
import javax.inject.Inject

open class SharedPreferencesManager @Inject constructor(
    @ApplicationContext private val context: Context
) : AppPreferences {


    companion object {
        const val USER_NAME = "user_name"
        const val TOKEN = "token"
        const val SESSION = "session"
    }

    private var preference = context.getSharedPreferences("shared-pref", Context.MODE_PRIVATE)
    private var editor = preference.edit()
    fun getPref(): SharedPreferences {
        return context.getSharedPreferences("shared-pref", Context.MODE_PRIVATE)
    }

    override var userName: String
        get() = getString(USER_NAME)
        set(value) {
            saveString(USER_NAME, value)
        }

    override fun getToken(): String {
        return getString(TOKEN, "")
    }

    override fun setToken(token: String) {
        saveString(TOKEN, token)
    }

    override fun hasLogin(): Boolean {
        return getBooleanData(SESSION)
    }

    override fun setLogin(value: Boolean) {
        saveBoolean(SESSION, value)
    }


    private fun saveString(key: String, value: String) {
        editor.putString(key, value).apply()
    }

    private fun getString(key: String, defaultValue: String = ""): String {
        return preference.getString(key, defaultValue) ?: defaultValue
    }

    private fun saveBoolean(key: String, value: Boolean) {
        editor.putBoolean(key, value)
    }

    private fun getBooleanData(key: String): Boolean {
        return preference.getBoolean(key, false)
    }

}