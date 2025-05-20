package com.example.quotesnap.di

import org.koin.androidx.viewmodel.dsl.viewModel
import com.example.quotesnap.ui.home.QuoteViewModel
import org.koin.dsl.module

val viewModelModule = module {
    viewModel { QuoteViewModel(get()) }
}