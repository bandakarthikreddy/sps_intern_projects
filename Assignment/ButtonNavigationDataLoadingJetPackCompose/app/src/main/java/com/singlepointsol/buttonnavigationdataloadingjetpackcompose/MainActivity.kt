package com.singlepointsol.buttonnavigationdataloadingjetpackcompose

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.singlepointsol.buttonnavigationdataloadingjetpackcompose.ui.theme.ButtonNavigationDataLoadingJetPackComposeTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            ButtonNavigationDataLoadingJetPackComposeTheme {
                val navController = rememberNavController()
                NavHost(
                    navController = navController,
                    startDestination = "LoadButton"
                ) {
                    composable("LoadButton") {
                        LoadButton(navController)
                    }
                    composable("FriendsList") {
                        FriendsListScreen()
                    }
                }
            }
        }
    }
}
