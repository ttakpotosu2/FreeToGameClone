package com.example.freetogameclone

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.navigation.compose.rememberNavController
import com.example.freetogameclone.presentation.navigation.NavigationGraph
import com.example.freetogameclone.presentation.sceens.DetailScreen
import com.example.freetogameclone.presentation.ui.theme.FreeToGameCloneTheme
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            FreeToGameCloneTheme {
                // A surface container using the 'background' color from the theme
                val navController = rememberNavController()
                NavigationGraph(navHostController = navController)
            }
        }
    }
}
