package com.singlepointsol.imagesassignmentlazygrid

import androidx.compose.animation.AnimatedVisibility
import androidx.compose.animation.animateContentSize
import androidx.compose.animation.core.Animation
import androidx.compose.animation.core.tween
import androidx.compose.animation.fadeIn
import androidx.compose.animation.fadeOut
import androidx.compose.animation.slideInHorizontally
import androidx.compose.animation.slideInVertically
import androidx.compose.animation.slideOutVertically
import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.Image
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.lazy.grid.itemsIndexed
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.core.app.NotificationCompat.Style

// Composable for the Main Activity which is called in the setContent with the modifier as inner padding
@Composable
fun ImageVerticalGrid(modifier: Modifier = Modifier) {
    LazyVerticalGrid(modifier = modifier)
}

// Composable for the Image Lazy Vertical Grid and receiving data from the Data Class Function as follows
@Composable
fun LazyVerticalGrid(modifier: Modifier = Modifier) {
    LazyVerticalGrid(
        modifier = Modifier
            .fillMaxSize()
            .padding(top = 16.dp),
        contentPadding = PaddingValues(vertical = 32.dp),
        columns = GridCells.Fixed(2)
    ) {
        itemsIndexed(items = getAllImages()) { index, item ->

            var visible by remember { mutableStateOf(false) }

            LaunchedEffect(Unit) {
                visible = true
            }

            AnimatedVisibility(
                visible = visible,
                enter = fadeIn(animationSpec = tween(3000)) + slideInHorizontally(
                    animationSpec = tween(3000)
                ),
                exit = fadeOut(animationSpec = tween(300)) + slideOutVertically(
                    animationSpec = tween(300)
                )
            ) {
                GridItems(
                    item = item, modifier = Modifier.padding(8.dp)
                )
            }
            /*
            GridItems(
                item = item, modifier = Modifier.padding(8.dp)
            )
            */
        }
    }
}

// Individual Grid Item
@Composable
fun GridItems(item: Image, modifier: Modifier = Modifier) {
    Column(
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally,
        modifier = modifier
            .height(250.dp) // Adjust height to accommodate text
            .fillMaxWidth()
            .border(BorderStroke(2.dp, Color.Black))
    ) {
        // Display Image
        Image(
            painter = painterResource(id = item.image),
            contentDescription = item.name,
            modifier = Modifier
                .height(200.dp)
                .fillMaxWidth()
                .animateContentSize(tween(600)),
                //.fillMaxHeight(),
            contentScale = ContentScale.Crop
        )

        // Display Text below the image
        Text(
        text = item.name,
            style = TextStyle(
                fontSize = 18.sp,
                fontWeight = FontWeight.Bold
            ),
            modifier = Modifier.padding(top = 8.dp)

        )
    }
}

