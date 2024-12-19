package com.singlepointsol.vechileimagetextlazyjetpackcompose

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.singlepointsol.vechileimagetextlazyjetpackcompose.ui.theme.CarListDemo
import com.singlepointsol.vechileimagetextlazyjetpackcompose.ui.theme.VechileImageTextLazyJetpackComposeTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            VechileImageTextLazyJetpackComposeTheme {
                Scaffold(modifier = Modifier.padding()) { innerPadding ->
                    CarListDemo(modifier = Modifier.padding(innerPadding))
                }
            }
        }
    }
}