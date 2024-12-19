package com.singlepointsol.imagelazystaggeredgrid

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.Image
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.staggeredgrid.LazyVerticalStaggeredGrid
import androidx.compose.foundation.lazy.staggeredgrid.StaggeredGridCells
import androidx.compose.foundation.lazy.staggeredgrid.itemsIndexed
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp

// Main Function which is Called in Main Activity with Modifiers to present it correctly
@Composable
fun ImageLazyVerticalStaggerGrid(modifier: Modifier = Modifier) {
    ImageVerticalStaggeredGrid(modifier = modifier)
}

// Sub Function To declare the other function and data class along with Setting the Arrangement for the App
@Composable
fun ImageVerticalStaggeredGrid(modifier: Modifier = Modifier) {
    LazyVerticalStaggeredGrid(
        columns = StaggeredGridCells.Fixed(2),
        modifier = modifier
            .fillMaxWidth(),
        verticalItemSpacing = 3.dp,
    ) {
        itemsIndexed(getAllImages()) { index, item ->
            GridItem(item = item, modifier = Modifier.padding(3.dp))
        }   
    }
}

// Individual Grid Item
@Composable
fun GridItem(item: ImageDetails, modifier: Modifier = Modifier) {
    Column(
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally,
        modifier = modifier
            .fillMaxWidth()
            .border(BorderStroke(2.dp, Color.Black))
    ) {
        // Display Image
        Image(
            painter = painterResource(id = item.image),
            contentDescription = "Image",
            modifier = Modifier.fillMaxWidth(),
            contentScale = ContentScale.Crop
        )
    }
}
