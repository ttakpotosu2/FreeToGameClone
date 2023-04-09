package com.example.freetogameclone.data.remote

import com.example.freetogameclone.data.model.Games
import retrofit2.http.GET

interface FreeToGameApi {

    @GET("games")
    suspend fun getGames(): List<Games> //TODO: Do we add an id query?
}