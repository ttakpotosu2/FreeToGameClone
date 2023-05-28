package com.example.freetogameclone.presentation.games

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.freetogameclone.data.model.Game
//import com.example.freetogameclone.data.repository.GamesPlatformRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

//@HiltViewModel
//class GamePlatformViewModel @Inject constructor(
//    private val repository: GamesPlatformRepository,
//    ) : ViewModel() {
//
//    private val _platform = MutableStateFlow<UiState>(UiState.Loading)
//    val platform: StateFlow<UiState> = _platform.asStateFlow()
//
//    init {
//        getPlatform()
//    }
//
//    private fun getPlatform(){
//        viewModelScope.launch {
//            val result = repository.getGamesByPlatform()
//            _platform.value = UiState.Success(data = result)
//        }
//    }
//}
//
//
//sealed class UiState {
//    object Loading: UiState()
//    data class Success(val data: List<Game>): UiState()
//}