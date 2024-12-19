package com.singlepointsol.myapplication

import android.widget.Toast
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavHostController
import com.google.firebase.auth.FirebaseAuth

@Composable
fun SignIn(navController: NavHostController) {
    val email = remember { mutableStateOf("") }
    val password = remember { mutableStateOf("") }
    val context = LocalContext.current
    val auth = FirebaseAuth.getInstance()

    Column(
        verticalArrangement = Arrangement.Top,
        horizontalAlignment = Alignment.CenterHorizontally,
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp)
    ) {
        OutlinedTextField(
            value = email.value,
            onValueChange = { email.value = it },
            label = { Text("Email Address") },
            modifier = Modifier
                .fillMaxWidth()
                .padding(bottom = 8.dp)
        )
        OutlinedTextField(
            value = password.value,
            onValueChange = { password.value = it },
            label = { Text("Password") },
            modifier = Modifier
                .fillMaxWidth()
                .padding(bottom = 16.dp)
        )
        Button(
            onClick = {
                if (email.value.isNotEmpty() && password.value.isNotEmpty()) {
                    auth.signInWithEmailAndPassword(email.value, password.value)
                        .addOnCompleteListener { task ->
                            if (task.isSuccessful) {
                                navController.navigate("MainScreen")
                            } else {
                                Toast.makeText(context, "Authentication failed: ${task.exception?.message}", Toast.LENGTH_SHORT).show()
                            }
                        }
                } else {
                    Toast.makeText(context, "Please enter email and password", Toast.LENGTH_SHORT).show()
                }
            },
            modifier = Modifier
                .fillMaxWidth()
                .padding(bottom = 8.dp)
        ) {
            Text(
                text = "SIGN IN",
                color = Color.White,
                style = TextStyle(fontSize = 18.sp, fontWeight = FontWeight.Bold)
            )
        }
        Button(
            onClick = {
                navController.navigate("home_screen")
            },
            modifier = Modifier.fillMaxWidth()
        ) {
            Text(
                text = "SIGN UP",
                color = Color.White,
                style = TextStyle(fontSize = 18.sp, fontWeight = FontWeight.Bold)
            )
        }
    }
}

