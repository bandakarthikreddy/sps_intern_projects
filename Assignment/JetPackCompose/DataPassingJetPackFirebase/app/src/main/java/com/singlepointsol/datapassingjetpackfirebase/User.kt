package com.singlepointsol.datapassingjetpackfirebase

import android.util.Log
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.google.firebase.database.FirebaseDatabase


@Composable
fun UserDemo(modifier: Modifier = Modifier) {
    val name = remember { mutableStateOf("") }
    val email = remember { mutableStateOf("") }
    val mobile = remember { mutableStateOf("") }


    val database = FirebaseDatabase.getInstance().getReference("Users")

    Column {
        Spacer(
            modifier = Modifier
                .height(36.dp)
        )
        // Name Text Field
        OutlinedTextField(
            value = name.value,
            onValueChange = { name.value = it },
            modifier = Modifier.fillMaxWidth()
                .padding(top = 8.dp),
            label = {
                Text(
                    text = "Name",
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(8.dp)
                )
            }
        )
        // Space for the next one
        Spacer(
            modifier = Modifier
                .height(8.dp)
        )
        // Email Text Field
        OutlinedTextField(
            value = email.value ,
            onValueChange = { email.value = it },
            modifier = Modifier.fillMaxWidth()
                .padding(top = 8.dp),
            label = {
                Text(
                    text = "Email",
                            modifier = Modifier
                            .fillMaxWidth()
                        .padding(8.dp)
                )
            }
        )
        // Space for the next one
        Spacer(
            modifier = Modifier
                .height(8.dp)
        )
        // Mobile Text Field
        OutlinedTextField(
            value = mobile.value,
            onValueChange = { mobile.value = it },
            modifier = Modifier.fillMaxWidth()
                .padding(top = 8.dp),
            label = {
                Text(
                    text = "Mobile",
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
        // Button
        Button(
            onClick = {
                val user = UserDetails (
                    name = name.value,
                    email = email.value,
                    mobile = mobile.value
                )
                database.push().setValue(user).addOnCompleteListener { task ->
                    if (task.isSuccessful) {
                        Log.d("Firebase", "Data Saved Successfully")
                    }
                    else {
                        Log.e("Firebase", "Error")
                    }
                }

            },
            modifier = Modifier
                .fillMaxWidth()
                .align(Alignment.CenterHorizontally)
                .padding(8.dp)
        ) {
            Text(
                text = "SUBMIT"
            )
        }
    }
}
