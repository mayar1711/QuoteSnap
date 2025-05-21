package com.example.quotesnap.di

import android.app.Application
import androidx.room.Room
import com.example.quotesnap.data.local.QuoteDatabase
import org.koin.dsl.module

val databaseModule = module {

    single {
        Room.databaseBuilder(
            get<Application>(),
            QuoteDatabase::class.java,
            "quote_db"
        ).build()
    }

    single { get<QuoteDatabase>().favoriteQuoteDao() }
}
