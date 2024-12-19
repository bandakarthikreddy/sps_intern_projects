package com.singlepointsol.myapplication

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Surface
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.singlepointsol.myapplication.ui.theme.MyApplicationTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            MyApplicationTheme {
                Surface(modifier = Modifier.fillMaxHeight().padding(top=32.dp, start = 1.dp, end = 1.dp, bottom = 4.dp)) {
                    val navController = rememberNavController()
                    NavHost(
                        navController = navController,
                        startDestination = "SignInScreen"
                    ) {
                        composable("SignInScreen") {
                            SignIn(navController)
                        }
                        composable("SignUpScreen") {
                            SignUp(navController)
                        }
                        composable("home_screen") {
                            HomeScreen(navController)
                        }
                }

                }
            }
        }
    }
}
