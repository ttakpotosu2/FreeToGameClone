package com.example.freetogameclone.data.local

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.example.freetogameclone.domain.GamesRemoteKeys

@Dao
interface GamesRemoteKeysDao {
    @Query("SELECT * FROM games_remote_keys_table WHERE id = :id")
    fun getGamesRemoteKeys(id: Int): GamesRemoteKeys

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun addGamesRemoteKeys(remoteKeys: List<GamesRemoteKeys>)

    @Query("DELETE FROM games_remote_keys_table")
    suspend fun deleteGamesRemoteKeys()
}