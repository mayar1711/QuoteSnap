package com.example.quotesnap.di

import com.example.quotesnap.data.api.QuoteApi
import org.koin.dsl.module
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

val networkModule = module {
    single {
        Retrofit.Builder()
            .baseUrl("https://zenquotes.io/api/")
            .addConverterFactory(GsonConverterFactory.create())
            .build()
    }

    single<QuoteApi> {
        get<Retrofit>().create(QuoteApi::class.java)
    }
}