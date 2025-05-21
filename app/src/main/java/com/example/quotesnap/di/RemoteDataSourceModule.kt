package com.example.quotesnap.di

import com.example.quotesnap.data.local.LocalDataSource
import com.example.quotesnap.data.local.LocalDataSourceImp
import com.example.quotesnap.data.remote.RemoteDataSource
import com.example.quotesnap.data.remote.RemoteDataSourceImp
import com.example.quotesnap.data.repo.QuoteRepositoryImpl
import com.example.quotesnap.domain.QuoteRepository
import org.koin.dsl.module

val remoteDataSourceModule = module {
    single<RemoteDataSource> { RemoteDataSourceImp(get()) }
}

val localDataSourceModule = module {
    single<LocalDataSource> { LocalDataSourceImp(get()) }

}
val repositoryModule = module {
    single<QuoteRepository> { QuoteRepositoryImpl(get(), get()) }
}
