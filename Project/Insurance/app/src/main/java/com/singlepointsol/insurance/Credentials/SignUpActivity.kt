package com.singlepointsol.insurance.Credentials

import androidx.compose.foundation.layout.*
import androidx.compose.material3.Button
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.focus.focusModifier
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

@Preview
@Composable
fun Preview() {
    SignUpActivity(modifier = Modifier.fillMaxSize())
}

@Composable
fun SignUpActivity(modifier: Modifier) {
    // State holders for the input fields
    val firstName = remember { mutableStateOf("") }
    val lastName = remember { mutableStateOf("") }
    val dateOfBirth = remember { mutableStateOf("") }
    val mobileNumber = remember { mutableStateOf("") }
    val emailAddress = remember { mutableStateOf("") }
    val password = remember { mutableStateOf("") }
    val confirmPassword = remember { mutableStateOf("") }

    // Main content
    Column(
        modifier = modifier
            .padding(start = 8.dp, end = 8.dp, bottom = 8.dp),
        verticalArrangement = Arrangement.Top,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        // First Name Field
        OutlinedTextField(
            value = firstName.value,
            onValueChange = { firstName.value = it },
            modifier = Modifier.fillMaxWidth(),
            label = {
                Text(
                    text = "First Name",
                    style = TextStyle(
                        fontSize = 12.sp,
                        fontStyle = FontStyle.Normal,
                        fontWeight = FontWeight.Normal
                    )
                )
            }
        )
        Spacer(
            modifier = Modifier
                .height(8.dp)
        )

        // Last Name Field
        OutlinedTextField(
            value = lastName.value,
            onValueChange = { lastName.value = it },
            modifier = Modifier.fillMaxWidth(),
            label = {
                Text(
                    text = "Last Name",
                    style = TextStyle(
                        fontSize = 12.sp,
                        fontStyle = FontStyle.Normal,
                        fontWeight = FontWeight.Normal
                    )
                )
            }
        )
        Spacer(
            modifier = Modifier
                .height(8.dp)
        )

        OutlinedTextField(
            value = dateOfBirth.value,
            onValueChange = {dateOfBirth.value = it},
            modifier = Modifier
                .fillMaxWidth(),
            label = {
                Text(
                    text = "Date of Birth",
                    style = TextStyle(
                        fontSize = 12.sp,
                        fontWeight = FontWeight.Normal,
                        fontStyle = FontStyle.Normal
                    )
                )
            }
        )
        Spacer(
            modifier = Modifier
                .height(8.dp)
        )

        OutlinedTextField(
            value = mobileNumber.value,
            onValueChange = {mobileNumber.value = it},
            modifier = Modifier
                .fillMaxWidth(),
            label = {
                Text(
                    text = "Mobile Number",
                    style = TextStyle(
                        fontSize = 12.sp,
                        fontWeight = FontWeight.Normal,
                        fontStyle = FontStyle.Normal
                    )
                )
            }
        )

        Spacer(
            modifier = Modifier
                .height(8.dp)
        )

        OutlinedTextField(
            value = emailAddress.value,
            onValueChange = {emailAddress.value = it},
            modifier = Modifier
                .fillMaxWidth(),
            label = {
                Text(
                    text = "Email Address",
                    style = TextStyle(
                        fontSize = 12.sp,
                        fontWeight = FontWeight.Normal,
                        fontStyle = FontStyle.Normal
                    )
                )
            }
        )

        Spacer(
            modifier = Modifier
                .height(8.dp)
        )

        OutlinedTextField(
            value = password.value,
            onValueChange = {password.value = it},
            modifier = Modifier
                .fillMaxWidth(),
            label = {
                Text(
                    text = "Password",
                    style = TextStyle(
                        fontSize = 12.sp,
                        fontWeight = FontWeight.Normal,
                        fontStyle = FontStyle.Normal
                    )
                )
            }
        )

        Spacer(
            modifier = Modifier
                .height(8.dp)
        )

        OutlinedTextField(
            value = confirmPassword.value,
            onValueChange = {confirmPassword.value = it},
            modifier = Modifier
                .fillMaxWidth(),
            label = {
                Text(
                    text = "Confirm Password",
                    style = TextStyle(
                        fontSize = 12.sp,
                        fontWeight = FontWeight.Normal,
                        fontStyle = FontStyle.Normal
                    )
                )
            }
        )

        Spacer(
            modifier = Modifier
                .height(8.dp)
        )

        Button(
            onClick = { /* Handle signup click */ },
            modifier = Modifier.fillMaxWidth()
        ) {
            Text(
                text = "SIGNUP",
                style = TextStyle(
                    fontSize = 14.sp,
                    fontWeight = FontWeight.Bold,
                    fontStyle = FontStyle.Normal
                )
            )
        }
    }
}
