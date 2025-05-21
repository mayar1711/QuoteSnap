package com.example.quotesnap.data.local

import com.example.quotesnap.data.model.FavoriteQuoteEntity
import kotlinx.coroutines.flow.Flow

interface LocalDataSource {
    fun getFavoriteQuotes(): Flow<List<FavoriteQuoteEntity>>
    suspend fun insertFavoriteQuote(favoriteQuote: FavoriteQuoteEntity)

}