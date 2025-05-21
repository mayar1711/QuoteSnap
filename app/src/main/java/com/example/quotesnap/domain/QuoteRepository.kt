package com.example.quotesnap.domain

import com.example.quotesnap.domain.model.Quote
import kotlinx.coroutines.flow.Flow

interface QuoteRepository {
    fun getRandomQuotes(): Flow<List<Quote>>
    fun fetchTodayQuote(): Flow<Quote>
    suspend fun insertFavoriteQuote(quote: Quote)
    fun getFavoriteQuotes(): Flow<List<Quote>>

}