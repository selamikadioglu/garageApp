package com.example.garage.module

import android.content.SharedPreferences
import com.example.garage.utils.SharedPreferencesManager
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object SharedModule {
    @Provides
    @Singleton
    fun provideSharedPreferences(): SharedPreferences =
        SharedPreferencesManager(GarageApplication().applicationContext).getPref()
}
