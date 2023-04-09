package com.example.freetogameclone.presentation.sceens

import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.paging.compose.collectAsLazyPagingItems
import coil.compose.rememberAsyncImagePainter
import com.example.freetogameclone.data.model.Games
import com.example.freetogameclone.presentation.games.GamesViewModel

@Composable
fun GamesScreen(
    gamesScreenViewModel: GamesViewModel = viewModel(),
) {
    val gamesList = gamesScreenViewModel.games.collectAsLazyPagingItems()

    LazyVerticalGrid(columns = GridCells.Fixed(2)){
        items(gamesList.itemCount){games ->
            gamesList[games]?.let {
             GamesListItem(gameDetails = it)
            }
        }
    }

//    LazyColumn(
//        modifier = Modifier.padding(16.dp),
//        verticalArrangement = Arrangement.spacedBy(16.dp)
//    ){
//        items(gamesList){games->
//            if (games != null) {
//                GamesListItem(gameDetails = games)
//            }
//        }
//    }
}

@Composable
fun GamesListItem(
    gameDetails: Games
) {

    val imagePainter = rememberAsyncImagePainter(
        model = gameDetails.thumbNail,
        error = painterResource(
            id = com.example.freetogameclone.R.drawable.ic_launcher_background
        )
    )

    Box(
        modifier = Modifier
            .size(width = 200.dp, height = 350.dp)
            .clickable { }
            .clip(RoundedCornerShape(12.dp))
            .padding(12.dp),
    ) {
        Image(
            painter = imagePainter,
            contentDescription = null,
            contentScale = ContentScale.FillBounds
        )
    }
}
