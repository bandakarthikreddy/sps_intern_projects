package com.singlepointsol.datavalidation

import MainActivity
import android.annotation.SuppressLint
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

class SignUpActivity : AppCompatActivity(), View.OnClickListener {
    lateinit var firstNameEditText: EditText
    lateinit var lastNameEditText: EditText
    lateinit var mobileEditText: EditText
    lateinit var emailEditText: EditText
    lateinit var passwordEditText: EditText
    lateinit var signUpButton: Button

    // Later for Shared Preferences
    lateinit var sharedPreferences: SharedPreferences

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_sign_up)

        //Loading views into Activity
        firstNameEditText = findViewById(R.id.firstName_et)
        lastNameEditText = findViewById(R.id.lastName_et)
        mobileEditText = findViewById(R.id.mobile_et)
        emailEditText = findViewById(R.id.emailSignUp_et)
        passwordEditText = findViewById(R.id.passwordSignup_et)
        signUpButton = findViewById(R.id.signupSignUp_button)

        //Setting Listeners
        firstNameEditText.setOnClickListener(this)
        lastNameEditText.setOnClickListener(this)
        mobileEditText.setOnClickListener(this)
        emailEditText.setOnClickListener(this)
        passwordEditText.setOnClickListener(this)
        signUpButton.setOnClickListener(this)

        // Later for Shared Preferences
        // Creation of Directory for shared Preferences
        sharedPreferences = getSharedPreferences("DataValidation", MODE_PRIVATE)


        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
    }

    override fun onClick(p0: View?) {
        if (p0 != null) {
            when (p0.id) {
                R.id.signupSignUp_button -> {
                    if (firstNameEditText.text.isEmpty() && lastNameEditText.text.isEmpty() && mobileEditText.text.isEmpty() && emailEditText.text.isEmpty() && passwordEditText.text.isEmpty()) {
                        val editor: SharedPreferences.Editor = sharedPreferences.edit()
                        editor.putString("firstNameKey", firstNameEditText.text.toString())
                        editor.putString("lastNameKey", lastNameEditText.text.toString())
                        editor.putString("mobileKey", mobileEditText.text.toString())
                        editor.putString("emailKey", emailEditText.text.toString())
                        editor.putString("passwordKey", passwordEditText.text.toString())
                        editor.apply()
                        firstNameEditText.text.clear()
                        lastNameEditText.text.clear()
                        mobileEditText.text.clear()
                        emailEditText.text.clear()
                        passwordEditText.text.clear()

                        Toast.makeText(this,"User create sucessfully", Toast.LENGTH_LONG).show()
                        val homeIntent = Intent(this, MainActivity::class.java)
                        Toast.makeText(this, "User created Successfully", Toast.LENGTH_LONG).show()
                        startActivity(homeIntent)
                        finish()
                    } else {
                        Toast.makeText(this, "All fields are required", Toast.LENGTH_LONG).show()
                    }
                }
            }
        }
    }
}



