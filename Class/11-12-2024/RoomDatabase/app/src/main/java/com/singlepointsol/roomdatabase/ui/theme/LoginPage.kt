package com.singlepointsol.roomdatabase.ui.theme

import android.util.Log
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
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
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import com.singlepointsol.roomdatabase.R

@Composable
fun LoginPage(modifier: Modifier = Modifier) {
    val email = remember { mutableStateOf("") }
    val password = remember { mutableStateOf("") }

    Column(
        verticalArrangement = Arrangement.Center,

        )
    {
        // Image View
        Image(painter = painterResource(R.drawable.android),
            contentDescription = stringResource(id = R.string.android),
            alignment = Alignment.Center,
            modifier = Modifier.fillMaxWidth()
                .padding(top = 60.dp)
        )
        // Email Text Field
        OutlinedTextField(
            value = email.value,
            onValueChange = { email.value = it },
            modifier = Modifier.fillMaxWidth()
                .padding(top = 8.dp),
            label = {
                Text(text = "Email")
            }

        )
        // Password Text Field
        OutlinedTextField(
            value = password.value,
            onValueChange = { password.value = it },
            modifier = Modifier
                .fillMaxWidth()
                .padding(top = 8.dp),
            label = {
                Text(text = "Password")
            }
        )
        // Row for Buttons
        Row(
            horizontalArrangement = Arrangement.End,
            verticalAlignment = Alignment.CenterVertically,
            modifier = Modifier.fillMaxWidth().padding(top = 16.dp) // Spacing above buttons
        ) {
            // Login Button
            Button(
                onClick = {
                    Log.e("Login Details", "Email: ${email.value}, Password: ${password.value}")
                },
                modifier = Modifier.padding(horizontal = 4.dp)
            ) {
                Text(text = "LOGIN")
            }
            // Signup Button
            Button(
                onClick = {
                    Log.i("Action", "Signup clicked")
                },
                modifier = Modifier.padding(horizontal = 4.dp)
            ) {
                Text(text = "SIGNUP")
            }

        }
    }
}
