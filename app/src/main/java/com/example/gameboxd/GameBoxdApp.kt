package com.example.gameboxd

import android.app.Application
import androidx.room.Room
import kotlin.jvm.java


class GameBoxdApp : Application() {

    companion object {
        lateinit var database: AppDatabase
            private set
    }

    override fun onCreate() {
        super.onCreate()

        // Initialize Room database
        database = Room.databaseBuilder(
            applicationContext,
            AppDatabase::class.java,
            "gameboxd-db"
        ).fallbackToDestructiveMigration() // wipes + rebuilds DB if schema changes
            .build()
    }
}