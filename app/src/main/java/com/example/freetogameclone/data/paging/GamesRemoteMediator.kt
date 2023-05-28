package com.example.freetogameclone.data.paging

import androidx.paging.ExperimentalPagingApi
import androidx.paging.LoadType
import androidx.paging.PagingState
import androidx.paging.RemoteMediator
import androidx.room.withTransaction
import com.example.freetogameclone.data.local.GamesDatabase
import com.example.freetogameclone.data.remote.FreeToGameApi
import com.example.freetogameclone.domain.GamesEntity
import com.example.freetogameclone.domain.GamesRemoteKeys
import javax.inject.Inject

@OptIn(ExperimentalPagingApi::class)
class GamesRemoteMediator @Inject constructor(
    private val api: FreeToGameApi,
    private val database: GamesDatabase
): RemoteMediator<Int, GamesEntity>() {

    private val gamesDao = database.gamesDao()
    private val remoteKeysDao = database.gamesRemoteKeysDao()

    override suspend fun load(
        loadType: LoadType,
        state: PagingState<Int, GamesEntity>
    ): MediatorResult {

        return try {
            val currentPage = when(loadType) {
                LoadType.REFRESH -> {
                    val remoteKeys = getRemoteKeyClosestToCurrentPosition(state)
                    remoteKeys?.next?.minus(1) ?: 1
                }
                LoadType.PREPEND -> {
                    val remoteKeys = getRemoteKeyForFirstItem(state)
                    val prevPage = remoteKeys?.prev
                        ?: return MediatorResult.Success(
                            endOfPaginationReached = remoteKeys != null
                        )
                    prevPage
                }
                LoadType.APPEND -> {
                    val remoteKeys = getRemoteKeyForLastItem(state)
                    val nextPage = remoteKeys?.next
                        ?: return MediatorResult.Success(
                            endOfPaginationReached = remoteKeys != null
                        )
                    nextPage
                }
            }

            val response = api.getGames(currentPage)

            val endOfPaginationReached = response.isEmpty()

            val prevPage = if (currentPage == 1) null else currentPage - 1
            val nextPage = if (endOfPaginationReached) null else currentPage + 1

            database.withTransaction {
                val keys = response.map { game ->
                    GamesRemoteKeys(
                        id = game.id,
                        prev = prevPage,
                        next = nextPage
                    )
                }
                remoteKeysDao.addGamesRemoteKeys(remoteKeys = keys)
                gamesDao.addGames(games = response.map {it.toGamesEntity()})
            }
            MediatorResult.Success(endOfPaginationReached = endOfPaginationReached)
        } catch (e: Exception) {
            e.printStackTrace()
            return MediatorResult.Error(e)
        }
    }

    private fun getRemoteKeyClosestToCurrentPosition(
        state: PagingState<Int, GamesEntity>
    ): GamesRemoteKeys? {
        return state.anchorPosition?.let { position ->
            state.closestItemToPosition(position)?.id?.let {
               remoteKeysDao.getGamesRemoteKeys(id = it)
            }
        }
    }

    private fun getRemoteKeyForFirstItem(
        state: PagingState<Int, GamesEntity>
    ): GamesRemoteKeys? {
        return state.pages.firstOrNull { it.data.isNotEmpty() }?.data?.firstOrNull()
            ?.let { remoteKeysDao.getGamesRemoteKeys(id = it.id)}
    }

    private fun getRemoteKeyForLastItem(
        state: PagingState<Int, GamesEntity>
    ): GamesRemoteKeys? {
        return state.pages.lastOrNull{ it.data.isNotEmpty() }?.data?.lastOrNull()
            ?.let { remoteKeysDao.getGamesRemoteKeys(id = it.id) }
    }
}