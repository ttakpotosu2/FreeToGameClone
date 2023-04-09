package com.example.freetogameclone.data.paging

import androidx.paging.PagingSource
import androidx.paging.PagingState
import com.example.freetogameclone.data.model.Games
import com.example.freetogameclone.data.repository.GamesRepository
import retrofit2.HttpException
import java.io.IOException

class GamesPagingSource(
    private val repository: GamesRepository
): PagingSource<Int, Games>() {
    override fun getRefreshKey(state: PagingState<Int, Games>): Int? {
        return state.anchorPosition
    }

    override suspend fun load(params: LoadParams<Int>): LoadResult<Int, Games> {
        return try {
            val currentPage = params.key ?: 1
            val response = repository.getGames()

            LoadResult.Page(
                data = response,
                prevKey = null,
                nextKey = if (response.isEmpty()) null else currentPage.plus(1)
            )
        } catch (exception: IOException) {
            LoadResult.Error(exception)
        } catch (exception: HttpException) {
            LoadResult.Error(exception)
        }
    }
}