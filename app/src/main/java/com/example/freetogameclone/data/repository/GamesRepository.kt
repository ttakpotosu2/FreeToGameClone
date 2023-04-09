package com.example.freetogameclone.data.repository

import com.example.freetogameclone.data.model.Games
import com.example.freetogameclone.data.remote.FreeToGameApi
import javax.inject.Inject

class GamesRepository @Inject constructor(
    private val freeToGameApi: FreeToGameApi
){

    suspend fun getGames(): List<Games> {
        return freeToGameApi.getGames()
    }
}