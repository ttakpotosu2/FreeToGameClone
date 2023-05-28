package com.example.freetogameclone.presentation.sceens

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.aspectRatio
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.paging.compose.collectAsLazyPagingItems
import androidx.paging.compose.itemContentType
import androidx.paging.compose.itemKey
import coil.compose.rememberAsyncImagePainter
import com.example.freetogameclone.R
import com.example.freetogameclone.domain.GamesEntity
import com.example.freetogameclone.presentation.games.GamesViewModel

@Composable
fun GamesScreen(
    viewModel: GamesViewModel = hiltViewModel(),
) {
    val gamesList = viewModel.games().collectAsLazyPagingItems()

    LazyVerticalGrid(
        columns = GridCells.Fixed(2),
        horizontalArrangement = Arrangement.spacedBy(16.dp),
        verticalArrangement = Arrangement.spacedBy(16.dp),
        modifier = Modifier
            .clip(RoundedCornerShape(12.dp))
            .background(Color(0xff121010))
    ) {
        items(gamesList.itemCount) { games ->
            gamesList[games]?.let {
                GamesListItem(gameDetails = it)
            }
        }
    }

//    LazyColumn(
//        modifier = Modifier
//            .fillMaxSize()
//            .background(Color(0xFF1e1e1e)),
//        verticalArrangement = Arrangement.spacedBy(16.dp)
//    ){
//        items(
//        count = gamesList.itemCount,
//        key = gamesList.itemKey(),
//        contentType = gamesList.itemContentType()
//    ){ index ->
//        val item = gamesList[index]
//        if (item != null) {
//            GamesListItem(gameDetails = item)
//        }
//        }
//    }
}

@Composable
fun GamesListItem(
    gameDetails: GamesEntity
) {
    val imagePainter = rememberAsyncImagePainter(
        model = gameDetails.thumbnail,
        error = painterResource(id = R.drawable.ic_launcher_background)
    )
    Box(
        modifier = Modifier
            .background(Color.DarkGray)
            .size(width = 200.dp, height = 350.dp)
            .clickable { }
            .clip(RoundedCornerShape(12.dp))
    ) {
        Image(
            painter = imagePainter,
            contentDescription = null,
            contentScale = ContentScale.Crop,
            modifier = Modifier.aspectRatio(ratio = 1f, matchHeightConstraintsFirst = true)
        )
    }
}
