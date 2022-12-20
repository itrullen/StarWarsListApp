package com.example.starwarslistapp

import android.app.Application
import com.example.starwarslistapp.di.appModule
import org.koin.android.ext.koin.androidContext
import org.koin.core.context.startKoin

class StarWarsListApplication : Application() {
    override fun onCreate() {
        super.onCreate()
        initKoin()
    }

    private fun initKoin() {
        startKoin {
            androidContext(this@StarWarsListApplication)
            modules(appModule)
        }
    }
}

