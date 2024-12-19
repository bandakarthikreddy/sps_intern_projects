package com.singlepointsol.lazyjetpackcompose

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

class MainActivity : ComponentActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            val friendsList = listOf("Karthik", "Gopi", "Naveen", "Surya", "Shiva", "Shravan", "Ajay", "Sanath",
                                    "Karthik", "Gopi", "Naveen", "Surya", "Shiva", "Shravan", "Ajay", "Sanath",
                                    "Karthik", "Gopi", "Naveen", "Surya", "Shiva", "Shravan", "Ajay", "Sanath",
                                    "Karthik", "Gopi", "Naveen", "Surya", "Shiva", "Shravan", "Ajay", "Sanath",
                                    "Karthik", "Gopi", "Naveen", "Surya", "Shiva", "Shravan", "Ajay", "Sanath",
                                    "Karthik", "Gopi", "Naveen", "Surya", "Shiva", "Shravan", "Ajay", "Sanath",
                                    "Karthik", "Gopi", "Naveen", "Surya", "Shiva", "Shravan", "Ajay", "Sanath",
                                    "Karthik", "Gopi", "Naveen", "Surya", "Shiva", "Shravan", "Ajay", "Sanath",
                                    "Karthik", "Gopi", "Naveen", "Surya", "Shiva", "Shravan", "Ajay", "Sanath")
            FriendsList(friendsList)
        }
    }
}

@Composable
fun FriendsList(friendsList: List<String>) {
    LazyColumn(
        modifier = Modifier.fillMaxWidth()
                            .padding(36.dp)
    ) {
        items(friendsList){
            Text(
                text = it,
                style = TextStyle(  color = Color.Red,
                                    fontSize = 24.sp)
            )
            Spacer(
                Modifier.height(10.dp)
            )
        }
    }
}