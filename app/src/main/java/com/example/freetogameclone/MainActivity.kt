package com.example.freetogameclone

import BrowserGamesScreen
import PCGamesScreen
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import com.example.freetogameclone.presentation.sceens.GamesScreen
import com.example.freetogameclone.presentation.ui.theme.FreeToGameCloneTheme
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            FreeToGameCloneTheme {
                // A surface container using the 'background' color from the theme
                BrowserGamesScreen()
            }
        }
    }
}
