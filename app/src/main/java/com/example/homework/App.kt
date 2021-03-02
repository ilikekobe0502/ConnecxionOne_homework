package com.example.homework

import android.app.Application
import com.example.homework.koin.appModule
import org.koin.android.ext.koin.androidContext
import org.koin.android.ext.koin.androidLogger
import org.koin.core.context.startKoin
import org.koin.core.logger.Level

open class App : Application() {

    companion object {
        lateinit var instance: App
    }

    override fun onCreate() {
        super.onCreate()
        instance = this
        // Koin
        startKoin {
            androidLogger(Level.ERROR)
            androidContext(instance)
            modules(appModule)
        }
    }
}