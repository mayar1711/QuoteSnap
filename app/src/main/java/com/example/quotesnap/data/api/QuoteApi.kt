package com.example.quotesnap.data.api

import com.example.quotesnap.data.model.Quote
import retrofit2.http.GET

interface QuoteApi {
    @GET("quotes")
    suspend fun getRandomQuote(): List<Quote>
}