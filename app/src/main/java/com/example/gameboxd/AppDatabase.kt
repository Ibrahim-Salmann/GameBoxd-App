package com.example.gameboxd

import androidx.room.Database
import androidx.room.RoomDatabase
import androidx.room.TypeConverters


// Add your entities here later (e.g., Review, Game, User)
@Database(
    entities = [GameEntity::class],
    version = 1,
    exportSchema = false
)
@TypeConverters(Converters::class)
abstract class AppDatabase : RoomDatabase() {
     abstract fun reviewDao(): GameDAO
}