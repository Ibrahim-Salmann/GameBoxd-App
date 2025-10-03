package com.example.gameboxd

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "games")
data class GameEntity (
    @PrimaryKey(autoGenerate = true) val id: Int = 0,
    val title: String,
    val genres: List<String>,      // instead of single String
    val platforms: List<String>,   // instead of single String
    val releaseYear: Int,
    val coverUrl: String?
)