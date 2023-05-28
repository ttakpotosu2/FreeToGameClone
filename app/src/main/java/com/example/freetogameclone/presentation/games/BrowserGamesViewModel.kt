package com.example.freetogameclone.presentation.games

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import androidx.paging.cachedIn
import com.example.freetogameclone.data.repository.BrowserGamesRepository
import com.example.freetogameclone.data.repository.GamesRepository
import com.example.freetogameclone.data.repository.PCGamesRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class BrowserGamesViewModel @Inject constructor(
    private val repository: BrowserGamesRepository
): ViewModel() {

    fun games() = repository.getBrowserGames().cachedIn(viewModelScope)
}