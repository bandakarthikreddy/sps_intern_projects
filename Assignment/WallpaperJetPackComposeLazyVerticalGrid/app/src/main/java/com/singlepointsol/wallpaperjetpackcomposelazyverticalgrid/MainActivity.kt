package com.singlepointsol.wallpaperjetpackcomposelazyverticalgrid

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.lifecycle.viewmodel.compose.viewModel
import com.singlepointsol.wallpaperjetpackcomposelazyverticalgrid.DataClass.WallpaperItem
import com.singlepointsol.wallpaperjetpackcomposelazyverticalgrid.WallpaperActivity.Wallpaperfun
import com.singlepointsol.wallpaperjetpackcomposelazyverticalgrid.ui.theme.WallpaperJetPackComposeLazyVerticalGridTheme

class MainActivity : ComponentActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            WallpaperJetPackComposeLazyVerticalGridTheme {
                Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->
                    val viewModel: WallpaperViewModel = viewModel()
                    val wallpapers by viewModel.wallpapers.collectAsState()

                    WallpaperScreen(
                        modifier = Modifier.padding(innerPadding),
                        wallpapers = wallpapers
                    )
                }
            }
        }
    }
}

@Composable
fun WallpaperScreen(modifier: Modifier, wallpapers: List<WallpaperItem>) {
    if (wallpapers.isNotEmpty()) {
        Wallpaperfun(
            modifier = modifier,
            items = wallpapers
        )
    } else {
        Greeting(
            name = "Fetching Wallpapers...",
            modifier = modifier
        )
    }
}

@Composable
fun Greeting(name: String, modifier: Modifier = Modifier) {
    androidx.compose.material3.Text(
        text = "Hello $name!",
        modifier = modifier
    )
}
