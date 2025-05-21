package com.example.quotesnap.data.local

import androidx.room.Database
import androidx.room.RoomDatabase
import com.example.quotesnap.data.model.FavoriteQuoteEntity

@Database(
    entities = [FavoriteQuoteEntity::class],
    version = 1,
    exportSchema = false
)
abstract class QuoteDatabase : RoomDatabase() {
    abstract fun favoriteQuoteDao(): FavoriteQuoteDao
}