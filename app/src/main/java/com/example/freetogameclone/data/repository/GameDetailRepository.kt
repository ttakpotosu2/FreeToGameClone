package com.example.freetogameclone.data.repository

import com.example.freetogameclone.data.local.GamesDatabase
import com.example.freetogameclone.domain.GamesEntity
import javax.inject.Inject

class GameDetailRepository @Inject constructor(
    private val database: GamesDatabase
) {

    suspend fun getGameById(gameId: String): GamesEntity {
        return database.gamesDao().getGame(gameId)
    }
}