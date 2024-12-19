package com.singlepointsol.insurance.Credentials

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp

@Composable
fun LogInActivity(modifier: Modifier) {
    val email = remember { mutableStateOf("") }
    val password = remember { mutableStateOf("") }
    Column(
        modifier = Modifier
            .fillMaxSize()
            .height(36.dp)
    ) {
        // Email Text Field
        OutlinedTextField(
            value = email.value,
            onValueChange = { email.value = it },
            modifier = Modifier
                .fillMaxSize(),
            label = {
                Text(
                    text = "Email Address",
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(8.dp)
                )
            }
        )
        Spacer(
            modifier = Modifier
                .height(8.dp)
        )

    // Password Text Field
        OutlinedTextField(
            value = password.value,
            onValueChange = {password.value = it },
            modifier = Modifier
                .fillMaxSize(),
            label = {
                Text(
                    text = "Password",
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(8.dp)
                )
            }
        )
    }
}