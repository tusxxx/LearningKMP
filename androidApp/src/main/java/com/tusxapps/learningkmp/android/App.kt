package com.tusxapps.learningkmp.android

import android.app.Application
import com.tusxapps.learningkmp.di.sharedModule
import org.koin.android.ext.koin.androidContext
import org.koin.android.ext.koin.androidLogger
import org.koin.core.context.startKoin

class App : Application() {
    override fun onCreate() {
        super.onCreate()
        startKoin {
            modules(sharedModule())
            androidLogger()
            androidContext(this@App)
        }
    }
}