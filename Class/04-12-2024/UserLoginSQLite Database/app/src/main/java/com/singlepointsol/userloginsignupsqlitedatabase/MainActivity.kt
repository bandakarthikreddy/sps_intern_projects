package com.singlepointsol.userloginsignupsqlitedatabase

import android.content.Intent
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import kotlin.math.sign
import kotlin.math.sin

class MainActivity : AppCompatActivity(), View.OnClickListener {
    // Declaring Globally
    // Edit Text
    lateinit var emailEditText: EditText
    lateinit var passwordEditText: EditText
    // Buttons
    lateinit var signInButton: Button
    lateinit var signUpButton: Button
    // DB Helper
    lateinit var userDBHelper: UserDBHelper
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)
        // Loading Views into Activity
        emailEditText = findViewById(R.id.emailSignIn_editText)
        passwordEditText = findViewById(R.id.passwordSignIn_editText)
        // Buttons
        signInButton = findViewById(R.id.signIn_button)
        signUpButton = findViewById(R.id.signUp_button)
        //Setting Listeners
        //Buttons
        signInButton.setOnClickListener(this)
        signUpButton.setOnClickListener(this)

        // DB Helper
        userDBHelper = UserDBHelper(this)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
    }

    override fun onClick(v: View?) {
        if (v != null) {
            when (v.id) {
                R.id.signIn_button -> {
                    val email = emailEditText.text.toString().trim()
                    val password = passwordEditText.text.toString().trim()

                    if (email.isNotEmpty() && password.isNotEmpty()) {
                        if (userDBHelper.isUserValid(email, password)) {
                            Toast.makeText(this, "Login Successful", Toast.LENGTH_LONG).show()
                            startActivity(Intent(this, WelcomeActivity:: class.java))
                        }
                        else {
                            Toast.makeText(this, "Invalid Username or Password", Toast.LENGTH_LONG).show()
                        }
                    } else {
                        Toast.makeText(this, "Please fill all fields", Toast.LENGTH_LONG).show()
                    }
                }
                R.id.signUp_button -> {
                    startActivity(Intent(this, SignUpActivity::class.java))
                }
            }
        }
    }
}