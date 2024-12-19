package com.singlepointsol.userloginsignupsqlitedatabase

import android.content.Intent
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.collection.emptyLongSet
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class SignUpActivity : AppCompatActivity(), View.OnClickListener {
    // Declaring Globally
    // Edit Text
    lateinit var nameEditText: EditText
    lateinit var emailEditText: EditText
    lateinit var passwordEditText: EditText
    lateinit var mobileEditText: EditText

    // Buttons
    lateinit var homeButton: Button

    // DB Helper
    lateinit var userDBHelper: UserDBHelper
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_sign_up)
        // Loading Views into Activity
        // Edit Text
        nameEditText = findViewById(R.id.nameSignUp_editText)
        emailEditText = findViewById(R.id.emailSignUp_editText)
        passwordEditText = findViewById(R.id.passwordSignUp_editText)
        mobileEditText = findViewById(R.id.mobileSignUp_editText)
        // Buttons
        homeButton = findViewById(R.id.home_button)
        userDBHelper = UserDBHelper(this)
        // Setting Listeners
        // Buttons
        homeButton.setOnClickListener(this)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
    }

    override fun onClick(v: View?) {
        if (v != null && v.id == R.id.home_button) {
            val name = nameEditText.text.toString().trim()
            val email = emailEditText.text.toString().trim()
            val password = passwordEditText.text.toString().trim()
            val mobile = mobileEditText.text.toString().trim()

            if (name.isNotEmpty() && email.isNotEmpty() && password.isNotEmpty() && mobile.isNotEmpty()) {
                    val result = userDBHelper.insertUser(name, email, password, mobile)
                    if (result != -1L) {
                        Toast.makeText(this, "Sign-Up Successful", Toast.LENGTH_LONG).show()
                        nameEditText.text.clear()
                        emailEditText.text.clear()
                        passwordEditText.text.clear()
                        mobileEditText.text.clear()

                        startActivity(Intent(this, MainActivity::class.java))
                        finish()
                    }
                        else
                            {
                        Toast.makeText(this, "Error during Sign-Up", Toast.LENGTH_LONG).show()
                        }
                }
            else
                {
                    Toast.makeText(this, "Invalid email address", Toast.LENGTH_LONG).show()
                }
            }
        else
            {
                Toast.makeText(this, "Please fill all fields", Toast.LENGTH_LONG).show()
            }
        }
    }