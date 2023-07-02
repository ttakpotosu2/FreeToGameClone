package com.example.freetogameclone.presentation.sceens

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
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
import androidx.navigation.NavHostController
import com.example.freetogameclone.R
import com.example.freetogameclone.presentation.navigation.Screens

@Composable
fun HomeScreen(
    navHostController: NavHostController
) {

    Column (
        modifier = Modifier
            .fillMaxSize()
            .background(Color.Black)
    ){
        Spacer(modifier = Modifier.weight(1f))
        Row(
            modifier = Modifier.padding(horizontal = 16.dp)
        ) {
            Image(
                painter = painterResource(id = R.drawable.ic_launcher_background),
                contentDescription = null,
                alignment = Alignment.Center,
                modifier = Modifier
                    .clip(CircleShape)
                    .size(60.dp)
                    .clickable { TODO() }
            )
            Spacer(modifier = Modifier.weight(1f))

            Icons.Default.Add
        }
        Spacer(modifier = Modifier.weight(1f))
        Text(
            text = "select a\ncategory to\nstart",
            style = TextStyle(
                fontSize = 38.sp,
                color = Color.White,
                lineHeight = 40.sp,
                letterSpacing = 4.sp
            ),
            modifier = Modifier.padding(16.dp)
        )
        Spacer(modifier = Modifier.weight(1f))
        LazyVerticalGrid(
            columns = GridCells.Fixed(2),
            verticalArrangement = Arrangement.spacedBy(16.dp),
            horizontalArrangement = Arrangement.spacedBy(16.dp)
        ){
            item { CategoryCard(
                categoryName = "all",
                backgroundColor = Color.Cyan,
                onClick = {navHostController.navigate(Screens.MainHomeScreen.route)}
            )
            }
            item {CategoryCard(
                categoryName = "pc games",
                backgroundColor = Color.Magenta,
                onClick = {navHostController.navigate(Screens.MainHomeScreen.route)}
            )
            }
            item { CategoryCard(
                categoryName = "browser games",
                backgroundColor = Color.Yellow,
                onClick = {navHostController.navigate(Screens.MainHomeScreen.route)}
            ) }
            item { CategoryCard(
                categoryName = "latest games",
                backgroundColor = Color.LightGray,
                onClick = {navHostController.navigate(Screens.MainHomeScreen.route)}
            ) }
        }
        Spacer(modifier = Modifier.weight(1f))
    }
}

@Composable
fun CategoryCard(
    categoryName: String,
    backgroundColor: Color,
    onClick: () -> Unit
) {
    Box(
        modifier = Modifier
            .clip(RoundedCornerShape(20.dp))
            .height(200.dp)
            .background(backgroundColor)
            .clickable { onClick() }
            .padding(16.dp),
        contentAlignment = Alignment.BottomStart
    ) {
        Text(
            text = categoryName,
            style = TextStyle(
                fontSize = 28.sp,
                color = Color.Black,
            )
        )
    }
}