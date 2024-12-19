package com.singlepointsol.myapplication

import android.widget.Toast
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
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
import androidx.navigation.NavController
import com.google.firebase.auth.FirebaseAuth

@Composable
fun SignUp(navController: NavController) {
    val context = LocalContext.current
    val name = remember { mutableStateOf("") }
    val mobile = remember { mutableStateOf("") }
    val email = remember { mutableStateOf("") }
    val password = remember { mutableStateOf("") }
    val confirmPassword = remember { mutableStateOf("") }

    val auth = FirebaseAuth.getInstance()

    Column(
        verticalArrangement = Arrangement.Top,
        horizontalAlignment = Alignment.Start,
        modifier = Modifier
            .fillMaxWidth()
            .padding(16.dp)
    ) {
        OutlinedTextField(
            value = name.value,
            onValueChange = { name.value = it },
            label = { Text("Full Name") },
            modifier = Modifier
                .fillMaxWidth()
                .padding(bottom = 16.dp)
        )
        OutlinedTextField(
            value = mobile.value,
            onValueChange = { mobile.value = it },
            label = { Text("Mobile Number") },
            modifier = Modifier
                .fillMaxWidth()
                .padding(bottom = 16.dp)
        )
        OutlinedTextField(
            value = email.value,
            onValueChange = { email.value = it },
            label = { Text("Email Address") },
            modifier = Modifier
                .fillMaxWidth()
                .padding(bottom = 16.dp)
        )
        OutlinedTextField(
            value = password.value,
            onValueChange = { password.value = it },
            label = { Text("Password") },
            modifier = Modifier
                .fillMaxWidth()
                .padding(bottom = 16.dp)
        )
        OutlinedTextField(
            value = confirmPassword.value,
            onValueChange = { confirmPassword.value = it },
            label = { Text("Confirm Password") },
            modifier = Modifier
                .fillMaxWidth()
                .padding(bottom = 16.dp)
        )
        Button(
            onClick = {
                when {
                    name.value.isEmpty() -> Toast.makeText(context, "Enter Name", Toast.LENGTH_LONG).show()
                    mobile.value.isEmpty() -> Toast.makeText(context, "Enter Mobile Number", Toast.LENGTH_LONG).show()
                    email.value.isEmpty() -> Toast.makeText(context, "Enter Email Address", Toast.LENGTH_LONG).show()
                    password.value.isEmpty() -> Toast.makeText(context, "Enter Password", Toast.LENGTH_LONG).show()
                    password.value != confirmPassword.value -> Toast.makeText(context, "Passwords do not match", Toast.LENGTH_LONG).show()
                    else -> {
                        auth.createUserWithEmailAndPassword(email.value, password.value)
                            .addOnCompleteListener { task ->
                                if (task.isSuccessful) {
                                    Toast.makeText(context, "Sign Up Successful", Toast.LENGTH_LONG).show()
                                    navController.navigate("SignInScreen")
                                } else {
                                    Toast.makeText(context, "Sign Up Failed: ${task.exception?.message}", Toast.LENGTH_LONG).show()
                                }
                            }
                    }
                }
            },
            modifier = Modifier.fillMaxWidth()
        ) {
            Text(
                text = "SIGN UP",
                style = TextStyle(fontSize = 18.sp, fontWeight = FontWeight.Bold),
                color = Color.White
            )
        }
    }
}
