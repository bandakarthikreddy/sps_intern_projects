package com.singlepointsol.myapplication

import android.os.Bundle
import android.widget.Button
import android.widget.Toast
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.ElevatedButton
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.sp
import com.singlepointsol.myapplication.ui.theme.MyApplicationTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        //enableEdgeToEdge()
        setContent {
            Column {
                //LoginPage()
                LoginScreen()
                //TODONotes()
            }
        }
    }
}
/*
                Text(
                    text = "Welcome to Jet Pack Compose",
                    fontSize = 30.sp,
                    color = Color.Blue
                )
                Text(
                    text = "Lets write Text Lines",
                    fontSize = 24.sp
                )
                Row {
                    ElevatedButton(onClick = {

                    }) {
                        Text(text = "Click Me")
                    }
                    Button(onClick = {

                    }) {
                        Text(text = "Click Me")
                    }
                }
                Image(
                    painter = painterResource(id = R.drawable.android),
                    contentDescription = stringResource(id = R.string.sample_image),
                    alignment = Alignment.Center
                )
                TextField(value = "Name", onValueChange = {})
            }
            */
