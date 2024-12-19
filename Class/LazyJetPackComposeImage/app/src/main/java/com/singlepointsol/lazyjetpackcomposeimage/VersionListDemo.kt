package com.singlepointsol.lazyjetpackcomposeimage

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.itemsIndexed
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Card
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.singlepointsol.lazyjetpackcomposeimage.ui.theme.Version
import com.singlepointsol.lazyjetpackcomposeimage.ui.theme.getallVersions

// Declaring Part

// Creating as a main function and calling it in the MainActivity
@Composable
fun VersionsListDemo(modifier: Modifier = Modifier) {
    LazyColumnDemo()
}

// Creating as sub-column and receiving data from Data Class Function to retrieve the Array List
// Then calling the another Version where it details about the Activity "How to display the content"
@Composable
fun LazyColumnDemo() {
    LazyColumn {
        itemsIndexed(items = getallVersions()) { index, item ->
            VersionItem(item = item)
        }
    }
}

// Layout or UI of the Activity

@Composable
fun VersionItem(item: Version, modifier: Modifier = Modifier) {
    Row(
        modifier = Modifier
            .fillMaxSize()
            .padding(top = 52.dp, start = 16.dp, end = 16.dp)
            .background(color = Color.LightGray)
            .clip(RoundedCornerShape(16.dp))
    ) {
        // Image
        Image(
            painter = painterResource(id = item.versionImage),
            contentDescription = item.versionName,
            modifier = Modifier
                .padding(4.dp)
                .size(96.dp)
                .align(Alignment.CenterVertically)
        )

        // Text Details
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(8.dp)
                .align(Alignment.CenterVertically),
            verticalArrangement = Arrangement.Center
        ) {
            Text(
                text = item.versionName,
                style = TextStyle(
                    color = Color.Red,
                    fontSize = 22.sp,
                    fontStyle = FontStyle.Italic
                )
            )
            Text(
                text = item.versionDetails,
                style = TextStyle(
                    color = Color.DarkGray,
                    fontSize = 20.sp
                )
            )
        }
    }
}
