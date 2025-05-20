package com.example.quotesnap

import android.app.Application
import com.example.quotesnap.di.networkModule
import com.example.quotesnap.di.repositoryModule
import com.example.quotesnap.di.viewModelModule
import org.koin.android.ext.koin.androidContext
import org.koin.core.context.GlobalContext.startKoin

class QuoteSnapApp : Application() {
    override fun onCreate() {
        super.onCreate()
        startKoin {
            androidContext(this@QuoteSnapApp)
            modules(
                listOf(
                    networkModule,
                    repositoryModule,
                    viewModelModule
                )
            )
        }
    }
}
