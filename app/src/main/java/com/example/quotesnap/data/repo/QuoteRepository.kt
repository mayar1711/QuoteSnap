package com.example.quotesnap.data.repo

import com.example.quotesnap.data.model.Quote
import com.example.quotesnap.data.api.QuoteApi

class QuoteRepository(private val api: QuoteApi) {
    suspend fun getRandomQuote(): Quote? {
        return try {
            api.getRandomQuote().firstOrNull()
        } catch (e: Exception) {
            null
        }
    }
}
