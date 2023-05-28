package com.example.freetogameclone.data.repository

import androidx.paging.ExperimentalPagingApi
import androidx.paging.Pager
import androidx.paging.PagingConfig
import androidx.paging.PagingData
import com.example.freetogameclone.data.local.GamesDatabase
import com.example.freetogameclone.data.paging.GamesRemoteMediator
import com.example.freetogameclone.data.remote.FreeToGameApi
import com.example.freetogameclone.domain.GamesEntity
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

class BrowserGamesRepository @Inject constructor(
    private val api: FreeToGameApi,
    private val database: GamesDatabase
){

    @OptIn(ExperimentalPagingApi::class)
    fun getBrowserGames(): Flow<PagingData<GamesEntity>> = Pager(
        config = PagingConfig(pageSize = 10),
        pagingSourceFactory = {database.gamesDao().getPlatform("Web Browser")},
        remoteMediator = GamesRemoteMediator(
            api, database
        )
    ).flow
}