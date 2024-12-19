package com.singlepointsol.insurance.splashscreen

import android.annotation.SuppressLint
import android.content.Intent
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.animation.core.Animatable
import androidx.compose.animation.core.EaseInOutSine
import androidx.compose.animation.core.tween
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.alpha
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import com.singlepointsol.insurance.MainActivity
import com.singlepointsol.insurance.R
import com.singlepointsol.insurance.ui.theme.InsuranceTheme
import kotlinx.coroutines.delay


@SuppressLint("CustomSplashScreen")
class SplashScreen : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            InsuranceTheme {
                SplashScreenContent(onSplashFinished = {
                    startActivity(Intent(this@SplashScreen, MainActivity::class.java))
                    finish() // Close SplashScreen Activity
                })
            }
        }
    }
}

@Composable
fun SplashScreenContent(onSplashFinished: () -> Unit) {
    val alpha = remember { Animatable(0f) } // Starts fully transparent

    // Animate alpha to 1f (fully visible) over 1.5 seconds, then trigger navigation
    LaunchedEffect(Unit) {
        alpha.animateTo(
            targetValue = 1f,
            animationSpec = tween(1000,100, easing = EaseInOutSine)
        )
        delay(1000L) // Wait an additional 0.5 seconds
        onSplashFinished()
    }

    // UI for Splash Screen
    Box(
        modifier = Modifier
            .fillMaxSize()
            .background(color = Color.Green),
        contentAlignment = Alignment.Center
    ) {
        Image(
            modifier = Modifier.alpha(alpha.value), // Apply alpha animation
            painter = painterResource(id = R.drawable.splash_screen_icon_png),
            contentDescription = "Splash Screen Icon"
        )/*
        Text(
            text = "ABC INSURANCE COMPANY",
            style = TextStyle(
                fontSize = 18.sp,
                fontWeight = FontWeight.Bold,
                color = Color.White
            )
        )
        */
    }
}
