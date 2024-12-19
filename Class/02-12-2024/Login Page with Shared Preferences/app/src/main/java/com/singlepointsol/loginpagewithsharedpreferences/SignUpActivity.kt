package com.singlepointsol.loginpagewithsharedpreferences

import android.content.Intent
import android.content.SharedPreferences
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class SignUpActivity : AppCompatActivity(), View.OnClickListener {
    // Global Variables Declarations
    // Edit Text
    lateinit var firstNameSignUpEditText: EditText
    lateinit var lastNameSignUpEditText: EditText
    lateinit var mobileSignUpEditText: EditText
    lateinit var emailSignUpEditText: EditText
    lateinit var passwordSignUpEditText: EditText
    // Buttons
    lateinit var homeSignUpButton: Button

    // Global declaration of Directory
    lateinit var sharedPreferences: SharedPreferences

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_sign_up)

        // Loading Views into Activity
        // Edit Text
        firstNameSignUpEditText = findViewById(R.id.firstNameSignUp_editText)
        lastNameSignUpEditText = findViewById(R.id.lastNameSignUp_editText)
        mobileSignUpEditText = findViewById(R.id.mobileSignUp_editText)
        emailSignUpEditText = findViewById(R.id.emailSignUp_editText)
        passwordSignUpEditText = findViewById(R.id.passwordSignUp_editText)

        // Buttons
        homeSignUpButton = findViewById(R.id.homeSignUp_button)

        // Setting Listeners
        firstNameSignUpEditText.setOnClickListener(this)
        lastNameSignUpEditText.setOnClickListener(this)
        mobileSignUpEditText.setOnClickListener(this)
        emailSignUpEditText.setOnClickListener(this)
        passwordSignUpEditText.setOnClickListener(this)
            // Buttons
        homeSignUpButton.setOnClickListener(this)

        // Directory
        sharedPreferences = getSharedPreferences("UserDetails", MODE_PRIVATE)

        // Edge to edge padding adjustment
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
    }

    override fun onClick(v: View?) {
        if (v != null) {
            when (v.id) {
                R.id.homeSignUp_button -> {
                    // Check if all fields are filled
                    if (firstNameSignUpEditText.text.isNotEmpty() &&
                        lastNameSignUpEditText.text.isNotEmpty() &&
                        mobileSignUpEditText.text.isNotEmpty() &&
                        emailSignUpEditText.text.isNotEmpty() &&
                        passwordSignUpEditText.text.isNotEmpty()) {



                        // Save data to SharedPreferences
                        val editor: SharedPreferences.Editor = sharedPreferences.edit()
                        editor.putString("firstNameKey", firstNameSignUpEditText.text.toString())
                        editor.putString("lastNameKey", lastNameSignUpEditText.text.toString())
                        editor.putString("mobileKey", mobileSignUpEditText.text.toString())
                        editor.putString("emailKey", emailSignUpEditText.text.toString())
                        editor.putString("passwordKey", passwordSignUpEditText.text.toString()) // Fix here
                        val isSaved = editor.commit() // Use commit to synchronously save data

                        // Check if the data was saved successfully
                        if (isSaved) {
                            // Clear the fields after saving
                            firstNameSignUpEditText.text.clear()
                            lastNameSignUpEditText.text.clear()
                            mobileSignUpEditText.text.clear()
                            emailSignUpEditText.text.clear()
                            passwordSignUpEditText.text.clear()

                            // Show success message
                            Toast.makeText(this, "User Created Successfully", Toast.LENGTH_LONG).show()

                            // Redirect to MainActivity
                            val homeIntent = Intent(this, MainActivity::class.java)
                            startActivity(homeIntent)
                            finish()
                        } else {
                            // If commit failed
                            Toast.makeText(this, "Failed to save user data", Toast.LENGTH_LONG).show()
                        }
                    } else {
                        // Show error message if any field is empty
                        Toast.makeText(this, "All fields are required", Toast.LENGTH_LONG).show()
                    }
                }
            }
        }
    }
}
