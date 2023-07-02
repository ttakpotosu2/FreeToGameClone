package com.example.freetogameclone.presentation.sceens

import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.pager.HorizontalPager
import androidx.compose.foundation.pager.rememberPagerState
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.hilt.navigation.compose.hiltViewModel
import coil.compose.rememberAsyncImagePainter
import com.example.freetogameclone.R
import com.example.freetogameclone.presentation.games.GameDetailViewModel
import com.example.freetogameclone.presentation.games.GameState

@OptIn(ExperimentalFoundationApi::class)
@Composable
fun DetailScreen(
    viewModel: GameDetailViewModel = hiltViewModel()
) {
    val game = viewModel.gameDetail.value
    val scroll = rememberScrollState()
    val style = TextStyle(
        fontSize = 20.sp,
        color = Color.White
    )
    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(Color(0xFF121010))
            .verticalScroll(scroll)
    ) {
        when (game) {
            is GameState.Success -> {
                Box(
                    modifier = Modifier.height(400.dp)
                ) {
                    val image = rememberAsyncImagePainter(model = game.game.screenShots)
                    val pagerState = rememberPagerState()


                    HorizontalPager(
                        pageCount = game.game.screenShots.size,
                        state = pagerState
                    ) { screenshot ->
                        Image(painter = painterResource(id = screenshot), contentDescription = null)
                    }
                    //  Image(painter = image, contentDescription = null)
                    Text(text = game.game.title)
                    Row(
                        modifier = Modifier
                            .height(50.dp)
                            .align(Alignment.BottomCenter)
                    ) {
                        repeat(game.game.screenShots.size) {
                            val color =
                                if (pagerState.currentPage == it) Color.Black else Color.Black.copy(
                                    .35f
                                )
                            Box(
                                modifier = Modifier
                                    .padding(start = 20.dp, end = 2.dp, bottom = 5.dp)
                                    .clip(CircleShape)
                                    .background(color)
                                    .size(8.dp)
                            )
                        }
                        Text(text = game.game.genre, style = style)
                        Text(text = game.game.status, style = style)
                        Image(
                            painter = painterResource(
                                id = if (game.game.platform == "PC (Windows)") {
                                    R.drawable.windows_logo
                                } else {
                                    R.drawable.web_logo
                                }
                            ),
                            contentDescription = null
                        )
                    }
                }
                Column(
                    modifier = Modifier.padding(8.dp)
                ) {
                    val info = game.game.minimumSystemRequirements


                    Text(text = game.game.description, style = style)
                    Text(text = "Developed by: ${game.game.developer}", style = style)
                    Text(text = "Released on: ${game.game.releaseDate}", style = style)
                    Text(
                        text = "This game runs on ${info?.os}, with ${info?.processor}," +
                                " ${info?.memory}, ${info?.graphics} and ${info?.storage} ",
                        style = style
                    )
                }
            }

            is GameState.Loading -> {
                CircularProgressIndicator()
            }
        }
    }
}