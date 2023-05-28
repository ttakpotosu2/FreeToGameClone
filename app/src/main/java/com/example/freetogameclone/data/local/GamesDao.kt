package com.example.freetogameclone.data.local

import androidx.paging.PagingSource
import androidx.room.Dao
import androidx.room.Query
import androidx.room.Upsert
import com.example.freetogameclone.domain.GamesEntity

@Dao
interface GamesDao {

    @Query("SELECT * FROM games_entity_table")
    fun getGames(): PagingSource<Int, GamesEntity>

    @Upsert
    suspend fun addGames(games: List<GamesEntity>)

    @Query("DELETE FROM games_entity_table" )
    suspend fun deleteGames()

    @Query("SELECT * FROM games_entity_table WHERE id = :id ")
    suspend fun getGame(id: Int): GamesEntity

    @Query("SELECT * FROM games_entity_table WHERE platform IN (:platform) ")
    fun getPlatform(platform: String): PagingSource<Int, GamesEntity>
}