package com.singlepointsol.roomdatabasetrying

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.*
import androidx.compose.material3.Button
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.singlepointsol.roomdatabasetrying.ui.theme.RoomDatabaseTryingTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            RoomDatabaseTryingTheme {
                MainScreen()
            }
        }
    }
}

@Composable
fun MainScreen() {
    Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->
        Column(
            modifier = Modifier
                .padding(innerPadding)
                .fillMaxSize(),
            verticalArrangement = Arrangement.Center,
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            EmployeeUI(name = "John Doe")
        }
    }
}

@Composable
fun EmployeeUI(name: String) {
    Column(horizontalAlignment = Alignment.CenterHorizontally) {
        Text(text = "Hello, $name!")
        Spacer(modifier = Modifier.height(16.dp))
        Button(onClick = { /* Add employee logic here */ }) {
            Text(text = "Add Employee")
        }
    }
}

@Preview(showBackground = true)
@Composable
fun MainScreenPreview() {
    RoomDatabaseTryingTheme {
        MainScreen()
    }
}
