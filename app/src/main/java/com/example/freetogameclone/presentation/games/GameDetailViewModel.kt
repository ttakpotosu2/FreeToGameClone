package com.example.freetogameclone.presentation.games

import androidx.compose.runtime.State
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.SavedStateHandle
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.freetogameclone.data.repository.GameDetailRepository
import com.example.freetogameclone.domain.GamesEntity
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

sealed class GameState {
    object Loading: GameState()
    data class Success(val game: GamesEntity): GameState()
 //   class Error(val message: String? = null) : GameState()
}

@HiltViewModel
class GameDetailViewModel @Inject constructor(
    private val repository: GameDetailRepository,
    savedStateHandle: SavedStateHandle
): ViewModel(){

    private val _gameDetail = mutableStateOf<GameState>(GameState.Loading)
    val gameDetail: State<GameState> = _gameDetail

    init {
        savedStateHandle.get<String>("gameId")?.let { gameById(it) }
    }

    private fun gameById(gameId: String){
        viewModelScope.launch {
            val result = repository.getGameById(gameId)
            _gameDetail.value = GameState.Success(result)
        }
    }
}