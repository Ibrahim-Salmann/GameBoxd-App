package com.example.gameboxd

import androidx.room.Database
import androidx.room.RoomDatabase

// Add your entities here later (e.g., Review, Game, User)
@Database(entities = [], version = 1)
abstract class AppDatabase : RoomDatabase() {
    // Example: abstract fun reviewDao(): ReviewDao
}