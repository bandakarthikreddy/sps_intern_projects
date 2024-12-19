package com.singlepointsol.vechileimagetextlazyjetpackcompose.ui.theme

import androidx.compose.animation.AnimatedVisibility
import androidx.compose.animation.core.FastOutLinearInEasing
import androidx.compose.animation.core.TweenSpec
import androidx.compose.animation.fadeOut
import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.itemsIndexed
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.singlepointsol.vechileimagetextlazyjetpackcompose.CarDetails
import com.singlepointsol.vechileimagetextlazyjetpackcompose.getAllCarDetails

@Composable
fun CarListDemo(modifier: Modifier = Modifier) {
    LazyCarDetails(modifier = modifier)
}

@Composable
fun LazyCarDetails(modifier: Modifier = Modifier) {
    LazyColumn(
        modifier = modifier.padding(start = 8.dp, top = 4.dp, end = 8.dp, bottom = 4.dp)
    ) {
        itemsIndexed(items = getAllCarDetails()) { index, item ->

                CarCard(item = item, modifier = Modifier.padding(4.dp))
            }
        }
    }

@Composable
fun CarCard(item: CarDetails, modifier: Modifier = Modifier) {
    Card(
        colors = CardDefaults.cardColors(
            containerColor = MaterialTheme.colorScheme.tertiaryContainer,
        ),
        elevation = CardDefaults.cardElevation(defaultElevation = 10.dp),
        border = BorderStroke(2.dp, Color.Black),
        modifier = modifier
            .fillMaxWidth(),
        shape = RoundedCornerShape(16.dp),
    ) {
        Row(
            verticalAlignment = Alignment.CenterVertically,
            modifier = Modifier.padding(8.dp)
        ) {
            // Image
            Image(
                painter = painterResource(id = item.carImage),
                contentDescription = item.carName,
                modifier = Modifier
                    .padding(end = 8.dp)
                    .size(120.dp)
                    .shadow(
                        elevation = 1.5.dp,
                        shape = RoundedCornerShape(55.dp)
                    )
                    .clip(RoundedCornerShape(10.dp))
            )

            // Text Details
            Column(
                verticalArrangement = Arrangement.Center,
                modifier = Modifier.fillMaxWidth()
            ) {
                // Car Name Text
                Text(
                    text = item.carName,
                    style = TextStyle(
                        color = Color.Black,
                        fontStyle = FontStyle.Italic,
                        fontSize = 24.sp,
                        fontWeight = FontWeight.Bold
                    )
                )
                // Car Transmission
                Text(
                    text = "Transmission: ${item.carTransmission}",
                    style = TextStyle(
                        color = Color.DarkGray,
                        fontStyle = FontStyle.Normal,
                        fontSize = 18.sp
                    )
                )
                // Car Power
                Text(
                    text = "Power: ${item.carPower}",
                    style = TextStyle(
                        color = Color.DarkGray,
                        fontSize = 18.sp,
                        fontStyle = FontStyle.Normal
                    )
                )
                // Car Torque
                Text(
                    text = "Torque: ${item.carTorque}",
                    style = TextStyle(
                        color = Color.DarkGray,
                        fontSize = 18.sp,
                        fontStyle = FontStyle.Normal
                    )
                )
            }
        }
    }
}
