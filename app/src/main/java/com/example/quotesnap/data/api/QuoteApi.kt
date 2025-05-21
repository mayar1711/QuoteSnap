package com.example.quotesnap.data.api

import com.example.quotesnap.data.model.AllQuoteResponse
import com.example.quotesnap.data.model.QuoteResponse
import retrofit2.http.GET

interface QuoteApi {
    @GET("quotes")
    suspend fun getRandomQuote(): List<AllQuoteResponse>

    @GET("today")
    suspend fun getTodayQuote(): List<QuoteResponse>

}