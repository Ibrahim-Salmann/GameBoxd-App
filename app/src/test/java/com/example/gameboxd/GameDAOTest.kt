package com.example.gameboxd

import androidx.room.Room
import androidx.test.core.app.ApplicationProvider
import kotlinx.coroutines.runBlocking
import org.junit.After
import org.junit.Assert.*
import org.junit.Before
import org.junit.Test

class GameDAOTest {

    private lateinit var db: AppDatabase
    private lateinit var dao: GameDAO

    @Before
    fun createDb() {
        // In-memory database for testing (wiped after each run)
        db = Room.inMemoryDatabaseBuilder(
            ApplicationProvider.getApplicationContext(),
            AppDatabase::class.java
        ).build()
        dao = db.reviewDao()
    }

    @After
    fun closeDb() {
        db.close()
    }

    @Test
    fun insertAndGetGame() = runBlocking {
        val game = GameEntity(title = "Elden Ring", genres = listOf("Action", "Adventure"), platforms = listOf("PC", "XBox series X", "Playstation 5"), releaseYear = 2022, coverUrl = null)
        dao.insertGame(game)

        val games = dao.getAllGames()
        assertEquals(1, games.size)
        assertEquals("Elden Ring", games[0].title)
    }

    @Test
    fun deleteGame() = runBlocking {
        val game = GameEntity(title = "The Legend of Zelda", genres = listOf("Action", "Adventure"),  platforms = listOf("Nintendo Switch"), releaseYear = 2017, coverUrl = null)
        dao.insertGame(game)
        dao.deleteGame(game)

        val games = dao.getAllGames()
        assertTrue(games.isEmpty())
    }


}