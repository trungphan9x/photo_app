package com.trung.photoapp

import android.app.Application
import android.content.Context
import com.trung.photoapp.di.repositoryModule
import com.trung.photoapp.di.roomModule
import com.trung.photoapp.di.viewModelModule
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
                listOf(viewModelModule, roomModule, repositoryModule)
            )
        }
    }

    companion object {
        lateinit var context: Context
    }
}