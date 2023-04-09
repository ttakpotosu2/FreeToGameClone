package com.example.freetogameclone.presentation.games

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import androidx.paging.Pager
import androidx.paging.PagingConfig
import androidx.paging.PagingData
import androidx.paging.cachedIn
import com.example.freetogameclone.data.model.Games
import com.example.freetogameclone.data.paging.GamesPagingSource
import com.example.freetogameclone.data.repository.GamesRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

@HiltViewModel
class GamesViewModel @Inject constructor(
    private val repository: GamesRepository
): ViewModel() {
    val games: Flow<PagingData<Games>> = Pager(
        PagingConfig(pageSize = 2)
    ){
        GamesPagingSource(repository)
    }.flow.cachedIn(viewModelScope)
}