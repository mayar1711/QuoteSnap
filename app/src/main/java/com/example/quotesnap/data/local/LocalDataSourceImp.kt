package com.example.quotesnap.data.local

import com.example.quotesnap.data.model.FavoriteQuoteEntity
import kotlinx.coroutines.flow.Flow

class LocalDataSourceImp(private val quoteDao: FavoriteQuoteDao) : LocalDataSource {
    override fun getFavoriteQuotes(): Flow<List<FavoriteQuoteEntity>> {
        return quoteDao.getFavoriteQuotes()
    }

    override suspend fun insertFavoriteQuote(favoriteQuote: FavoriteQuoteEntity) {
        quoteDao.insertFavoriteQuote(favoriteQuote)
    }
}
