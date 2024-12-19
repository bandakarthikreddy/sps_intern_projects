package com.singlepointsol.loginpagewithsharedpreferences

import android.content.Intent
import android.content.SharedPreferences
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class MainActivity : AppCompatActivity(), View.OnClickListener {
    // Declaring Global Variables
    // Edit Text
    lateinit var emailLoginEditText: EditText
    lateinit var passwordLoginEditText: EditText
    // Buttons
    lateinit var signUpButton: Button
    lateinit var signInButton: Button
    // Global Initialization for Shared Preferences
    lateinit var sharedPreferences: SharedPreferences

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)
        // Loading Views into activity
        // Edit Text
        emailLoginEditText = findViewById(R.id.emailLogin_editText)
        passwordLoginEditText = findViewById(R.id.passwordLogin_editText)
        // Buttons
        signUpButton = findViewById(R.id.signUpLogin_button)
        signInButton = findViewById(R.id.signInLogin_button)

        // Setting Listeners for Buttons
        emailLoginEditText.setOnClickListener(this)
        passwordLoginEditText.setOnClickListener(this)
        // Buttons
        signUpButton.setOnClickListener(this)
        signInButton.setOnClickListener(this)

        // Create a directory
        sharedPreferences = getSharedPreferences("UserDetails", MODE_PRIVATE)

        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
    }

    override fun onClick(v: View?) {
        if (v != null) {
            when (v.id) {
                R.id.signUpLogin_button -> {
                    val intent = Intent (this, SignUpActivity::class.java)
                    startActivity(intent)
                    finish()
                }
                R.id.signInLogin_button -> {
                    /*
                    if (sharedPreferences.contains("emailKey") && sharedPreferences.contains("passwordKey")) {
                        val email = sharedPreferences.getString("emailKey", null)
                        val password = sharedPreferences.getString("passwordKey", null)
                    }

                     */
                    if (emailLoginEditText.text.toString().isEmpty() || passwordLoginEditText.text.toString().isEmpty()){
                        Toast.makeText(this, "Enter Username adn Password", Toast.LENGTH_LONG).show()
                    }
                    else if (emailLoginEditText.text.toString() == sharedPreferences.getString("emailKey", null) &&
                            passwordLoginEditText.text.toString() == sharedPreferences.getString("passwordKey", null)) {
                        val intent  = Intent (this, WelcomeActivity::class.java)
                        startActivity(intent)
                    }
                    else {
                        Toast.makeText(this, "Invalid User", Toast.LENGTH_LONG).show()
                    }
                }
            }
        }
    }
}