package com.example.quotesnap.data.remote

import com.example.quotesnap.data.api.QuoteApi
import com.example.quotesnap.data.model.AllQuoteResponse
import com.example.quotesnap.data.model.QuoteResponse
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow

class RemoteDataSourceImp (private val quoteApi: QuoteApi) : RemoteDataSource  {
    override fun getRandomQuotes(): Flow<List<AllQuoteResponse>> = flow {
        emit(quoteApi.getRandomQuote())
    }

    override fun fetchTodayQuote(): Flow<QuoteResponse>  = flow {
        val todayQuoteList = quoteApi.getTodayQuote()
        emit(todayQuoteList[0])
    }
}