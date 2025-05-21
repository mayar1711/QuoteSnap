package com.example.quotesnap.data.remote

import com.example.quotesnap.data.model.AllQuoteResponse
import com.example.quotesnap.data.model.QuoteResponse
import com.example.quotesnap.domain.model.Quote
import kotlinx.coroutines.flow.Flow

interface RemoteDataSource {
    fun getRandomQuotes(): Flow<List<AllQuoteResponse>>
    fun fetchTodayQuote(): Flow<QuoteResponse>
}