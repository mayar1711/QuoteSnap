package com.example.quotesnap.data.repo

import com.example.quotesnap.data.local.LocalDataSource
import com.example.quotesnap.data.remote.RemoteDataSource
import com.example.quotesnap.domain.QuoteRepository
import com.example.quotesnap.domain.model.Quote
import com.example.quotesnap.data.model.toDomain
import com.example.quotesnap.data.model.toEntity
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map

class QuoteRepositoryImpl(
    private val remote: RemoteDataSource,
    private val local: LocalDataSource
) : QuoteRepository {

    override fun getRandomQuotes(): Flow<List<Quote>> =
        remote.getRandomQuotes().map { list ->
            list.map { it.toDomain() }
        }


    override fun fetchTodayQuote(): Flow<Quote> =
        remote.fetchTodayQuote().map { it.toDomain() }

    override suspend fun insertFavoriteQuote(quote: Quote) {
        local.insertFavoriteQuote(quote.toEntity())
    }

    override fun getFavoriteQuotes(): Flow<List<Quote>> =
        local.getFavoriteQuotes().map { list ->
            list.map { it.toDomain() }
        }

}

