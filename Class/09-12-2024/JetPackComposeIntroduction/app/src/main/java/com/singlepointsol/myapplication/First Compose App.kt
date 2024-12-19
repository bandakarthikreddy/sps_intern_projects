package com.singlepointsol.myapplication

import android.content.Intent
import android.net.Uri
import android.provider.ContactsContract.CommonDataKinds.Email
import android.util.Log
import androidx.activity.compose.rememberLauncherForActivityResult
import androidx.activity.result.contract.ActivityResultContract
import androidx.activity.result.contract.ActivityResultContracts
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material3.Button
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.focus.focusModifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.input.pointer.PointerIcon.Companion.Text
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

@Composable
fun LoginScreen() {
        val email = remember { mutableStateOf("") }
        val password = remember { mutableStateOf("")
        }
    Column (
            modifier = Modifier.fillMaxSize(),
            verticalArrangement = Arrangement.Center,
            horizontalAlignment = Alignment.CenterHorizontally)
    {
        // Image
        Image(
            painter = painterResource(R.drawable.loginpage),
            contentDescription = "Login Image",
            modifier = Modifier.size(300.dp)
        )

        // Stating Welcome Back
        Text(
            text = "Welcome Back",
            fontSize = 28.sp,
            fontWeight = FontWeight.Bold
        )

        // Spacer Modifier
        Spacer(
            modifier = Modifier.height(4.dp)
        )

        // Showing Information to Login to your account
        Text(
            text = "Login to your account"
        )

        // Spacer Modifier
        Spacer(
            modifier = Modifier.height(16.dp)
        )

        // Email
        OutlinedTextField(
            value = email.value,
            onValueChange = {
                email.value = it
            },
            label = {
                Text(text = "Email Address")
            })

        // Spacer Modifier
        Spacer(
            modifier = Modifier.height(16.dp)
        )

        // Password
        OutlinedTextField(
            value = password.value,
            onValueChange = {
                password.value = it
            },
            label = {
                Text(text = "Password")
            })

        // Space Modifier
        Spacer(
            modifier = Modifier.height(16.dp)
        )

        // Button - Login
        Button(onClick =  {


            //Log.i("Credential", "Email: $email.value Password: $password.value")
        }) {
            Text(
                text = "LOGIN"
            )
        }

        // Space Modifier
        Spacer(
            modifier = Modifier.height(32.dp)
        )


        // Text Button
        Text(
            text = "Forgot Password?",
            modifier = Modifier.clickable {

            }
        )

        // Space Modifier
        Spacer(
            modifier = Modifier.height(32.dp)
        )

        // Text
        Text(
            text = "Or Sign in with"
        )

        // Space Modifier
        Spacer(
            modifier = Modifier.height(32.dp)
        )
        Row (
            modifier = Modifier.fillMaxWidth()
                .padding(40.dp),
            horizontalArrangement = Arrangement.Center
        ) {
            // Image
            Image(painterResource(R.drawable.google),
                contentDescription = "Google",
                modifier = Modifier.size(50.dp).clickable {
                })

            // Image

            Image(painterResource(R.drawable.facebook),
                contentDescription = "Facebook",
                modifier = Modifier.size(60.dp).clickable {  })

            // Image
            Image(painterResource(R.drawable.twitter),
                contentDescription = "Twitter",
                modifier = Modifier.size(60.dp).clickable {  })
        }

    }


    }

