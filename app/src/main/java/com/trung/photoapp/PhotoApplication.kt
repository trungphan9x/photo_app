package com.trung.photoapp

import android.app.Application
import android.content.Context
import com.trung.photoapp.di.*
import org.koin.android.ext.koin.androidContext
import org.koin.core.context.startKoin

class PhotoApplication : Application() {
    override fun onCreate() {
        super.onCreate()

        PhotoApplication.context = applicationContext

        startKoin {
            // Android context
            androidContext(applicationContext)
            // modules
            modules(
                listOf(viewModelModule, roomModule, repositoryModule, apiModule, networkModule)
            )
        }
    }

    companion object {
        lateinit var context: Context
    }
}