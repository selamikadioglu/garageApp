package com.example.garage.utils

interface AppPreferences {
    var userName: String
    fun getToken(): String
    fun setToken(token: String)
    fun hasLogin():Boolean
    fun setLogin(value:Boolean)
}