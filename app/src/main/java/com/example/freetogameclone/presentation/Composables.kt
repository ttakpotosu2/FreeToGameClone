package com.example.freetogameclone.presentation

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavHostController
import coil.compose.rememberAsyncImagePainter
import com.example.freetogameclone.R
import com.example.freetogameclone.domain.GamesEntity
import com.example.freetogameclone.presentation.navigation.Screens

@Composable
fun GamesListItem(
    gameDetails: GamesEntity, navHostController: NavHostController
) {
    val imagePainter = rememberAsyncImagePainter(
        model = gameDetails.thumbnail,
        error = painterResource(id = R.drawable.ic_launcher_background)
    )
    Column(modifier = Modifier
        .size(width = 200.dp, height = 350.dp)
        .clickable {navHostController.navigate(Screens.DetailScreen.route + "/${gameDetails.id}")}
        .clip(RoundedCornerShape(20.dp))
        .background(Color.White)) {
        Image(
            painter = imagePainter,
            contentDescription = null,
            contentScale = ContentScale.Crop,
            modifier = Modifier.height(150.dp)
        )
        Text(
            text = gameDetails.title, modifier = Modifier.padding(8.dp), style = TextStyle(
                fontSize = 20.sp, color = Color.Black, fontWeight = FontWeight.Bold
            )
        )
        Text(
            text = gameDetails.shortDescription,
            modifier = Modifier.padding(8.dp),
            maxLines = 4,
            style = TextStyle(
                fontSize = 20.sp,
                color = Color.Black,
            ),
            overflow = TextOverflow.Ellipsis
        )
        Spacer(modifier = Modifier.weight(1f))
        Row(
            verticalAlignment = Alignment.CenterVertically, modifier = Modifier
                // .height(30.dp)
                .padding(8.dp)
        ) {
            Image(
                painter = painterResource(
                    if (gameDetails.platform == "PC (Windows)") {
                        R.drawable.windows_logo
                    } else {
                        R.drawable.web_logo
                    }
                ), contentDescription = null, modifier = Modifier.size(20.dp)
            )
            Spacer(modifier = Modifier.weight(1f))
            Text(
                text = gameDetails.genre,
                style = TextStyle(
                    color = Color.White, fontSize = 12.sp
                ),
                modifier = Modifier
                    .clip(RoundedCornerShape(100.dp))
                    .background(Color.Black)
                    .padding(4.dp)
            )
        }
    }
}