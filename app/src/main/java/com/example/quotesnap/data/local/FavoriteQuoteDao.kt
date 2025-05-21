package com.example.quotesnap.data.local

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.example.quotesnap.data.model.FavoriteQuoteEntity
import kotlinx.coroutines.flow.Flow

@Dao
interface FavoriteQuoteDao {
    @Insert(onConflict = OnConflictStrategy.IGNORE)
    suspend fun insertFavoriteQuote(quote: FavoriteQuoteEntity)

    @Query("SELECT * FROM favorite_quotes")
    fun getFavoriteQuotes(): Flow<List<FavoriteQuoteEntity>>
}
