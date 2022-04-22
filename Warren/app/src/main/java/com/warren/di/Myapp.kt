package com.warren.di

import android.app.Application
import org.koin.android.ext.koin.androidContext
import org.koin.core.context.startKoin

class Myapp:Application() {
    override fun onCreate() {
        super.onCreate()

        startKoin{
            androidContext(this@Myapp)
            modules(viewModelModule)
        }
    }
}
