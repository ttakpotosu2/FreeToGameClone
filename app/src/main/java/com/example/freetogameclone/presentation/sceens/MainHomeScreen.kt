package com.example.freetogameclone.presentation.sceens

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Tab
import androidx.compose.material3.TabRow
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.Color.Companion.Black
import androidx.compose.ui.graphics.Color.Companion.DarkGray
import androidx.compose.ui.graphics.Color.Companion.White
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavHostController

@Composable
fun MainHomeScreen(
    navHostController: NavHostController
) {
    TabView(navHostController)
}

@Composable
fun TabView(navHostController: NavHostController) {
    var selectedTabIndex by remember { mutableStateOf(0) }
    val inactiveColor = White.copy(.3f)
    val tabList = listOf(
        "all",
        "pc games",
        "browser games"
    )
    Column {
        TabRow(
            selectedTabIndex = selectedTabIndex,
            containerColor = Color(0xff121010),
            contentColor = Black
        ) {
            tabList.forEachIndexed { index, title ->
                Tab(
                    selected = selectedTabIndex == index,
                    selectedContentColor = DarkGray,
                    unselectedContentColor = Black,
                    modifier = Modifier.height(120.dp),
                    onClick = { selectedTabIndex = index }
                ) {
                    Text(
                        text = title,
                        color = if (selectedTabIndex == index) White else inactiveColor,
                        fontSize = 20.sp,
                        modifier = Modifier.padding(horizontal = 6.dp)
                    )
                }
            }
        }
        when(selectedTabIndex){
            0 -> {GamesScreen(navHostController = navHostController)}
            1 -> { PCGamesScreen(navHostController = navHostController) }
            2 -> { BrowserGamesScreen(navHostController = navHostController) }
        }
    }
}