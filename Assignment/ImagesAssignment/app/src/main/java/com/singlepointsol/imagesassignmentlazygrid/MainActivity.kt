package com.singlepointsol.imagesassignmentlazygrid

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.input.pointer.motionEventSpy
import androidx.compose.ui.tooling.preview.Preview
import com.singlepointsol.imagesassignmentlazygrid.ui.theme.ImagesAssignmentLazyGridTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            ImagesAssignmentLazyGridTheme {
                Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->
                    ImageVerticalGrid(modifier = Modifier.padding(innerPadding))
                }
            }
        }
    }
}