package com.example.quotesnap.di

import com.example.quotesnap.data.repo.QuoteRepository
import org.koin.dsl.module

val repositoryModule = module {
    single { QuoteRepository(get()) }
}
