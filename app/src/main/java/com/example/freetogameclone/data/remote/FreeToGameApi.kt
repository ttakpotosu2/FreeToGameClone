package com.example.freetogameclone.data.remote

import com.example.freetogameclone.data.model.Game
import retrofit2.http.GET
import retrofit2.http.Query

interface FreeToGameApi {

    @GET("games")
    suspend fun getGames(@Query("page") page: Int): List<Game>

    @GET("game")
    suspend fun getGame(@Query("id") id: Int): Game?
}