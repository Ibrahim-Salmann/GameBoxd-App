package com.example.gameboxd

//Game Data Access Object (DAO) - Placeholder for future implementation
import androidx.room.*

@Dao
interface GameDAO {

    // Example method to insert a game into the database
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertGame(game: GameEntity)

    // Example method to retrieve all games from the database
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertGames(games: List<GameEntity>)

    /// Example method to retrieve all games from the database
    @Query("SELECT * FROM games ORDER BY title ASC")
    suspend fun getAllGames(): List<GameEntity>

    // Example method to retrieve a game by its ID
    @Query("SELECT * FROM games WHERE id = :id")
    suspend fun getGameById(id: Int): GameEntity?

    // Example method to delete a game from the database
    @Delete
    suspend fun deleteGame(game: GameEntity)
}