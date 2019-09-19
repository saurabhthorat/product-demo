package com.saurabh.demo

import android.app.Application
import com.saurabh.demo.di.app_module
import org.koin.android.ext.koin.androidContext
import org.koin.core.context.startKoin

class App : Application() {
    override fun onCreate() {
        super.onCreate()
        startKoin {
            androidContext(this@App)
            modules(app_module)
        }
    }
}