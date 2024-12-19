package com.singlepointsol.datapassingjetpackfirebase

import android.os.Bundle
import android.widget.Button
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.google.firebase.database.FirebaseDatabase
import com.singlepointsol.datapassingjetpackfirebase.ui.theme.DataPassingJetPackFirebaseTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        // Initialize Firebase
        FirebaseDatabase.getInstance().setPersistenceEnabled(true)
        setContent {
            DataPassingJetPackFirebaseTheme {
                Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->
                    UserDemo(
                        modifier = Modifier.padding(innerPadding)
                    )
                }
            }
        }
    }
}
