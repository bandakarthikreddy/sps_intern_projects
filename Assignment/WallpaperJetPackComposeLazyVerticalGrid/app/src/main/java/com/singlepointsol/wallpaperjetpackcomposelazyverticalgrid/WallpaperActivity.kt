package com.singlepointsol.wallpaperjetpackcomposelazyverticalgrid.WallpaperActivity

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.lazy.grid.itemsIndexed
import androidx.compose.material3.Card
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import coil.compose.rememberAsyncImagePainter
import com.singlepointsol.wallpaperjetpackcomposelazyverticalgrid.DataClass.WallpaperItem

@Composable
fun Wallpaperfun(modifier: Modifier, items: List<WallpaperItem>) {
    LazyVerticalGrid(
        modifier = modifier
            .fillMaxWidth()
            .padding(8.dp),
        contentPadding = PaddingValues(vertical = 8.dp),
        columns = GridCells.Fixed(2)
    ) {
        itemsIndexed(items) { _, item ->
            Images(item = item, modifier = Modifier.padding(8.dp))
        }
    }
}

@Composable
fun Images(item: WallpaperItem, modifier: Modifier) {
    Column(
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally,
        modifier = modifier
            .height(250.dp)
            .fillMaxWidth()
    ) {
        Card {
            Image(
                painter = rememberAsyncImagePainter(model = item.previewURL), // Use painter parameter
                contentDescription = "Wallpaper by ${item.user}", // Proper usage of contentDescription
                modifier = Modifier
                    .height(200.dp)
                    .fillMaxWidth()
            )
        }
        Text(
            text = item.user,
            style = TextStyle(
                fontSize = 18.sp,
                fontWeight = FontWeight.Bold
            )
        )
    }
}
