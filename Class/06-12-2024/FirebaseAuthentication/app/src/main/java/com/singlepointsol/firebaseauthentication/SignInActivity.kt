package com.singlepointsol.firebaseauthentication

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
import com.google.firebase.Firebase
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.auth.auth

class SignInActivity : AppCompatActivity(), View.OnClickListener {
    // Declaring Globally
    // Edit Text
    private lateinit var emailEditText: EditText
    private lateinit var passwordEditText: EditText
    // Buttons
    private lateinit var signInButton: Button
    // private lateinit var signUpButton: Button
    //
    private lateinit var auth: FirebaseAuth

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_sign_in)
        // Loading Views into Activity
        // Edit Text
        emailEditText = findViewById(R.id.emailLogin_editText)
        passwordEditText = findViewById(R.id.passwordLogin_editText)
        // Buttons
        signInButton = findViewById(R.id.signInLogin_button)
        //signUpButton = findViewById(R.id.signUpLogin_button)
        // Initialize Firebase Auth
        auth = Firebase.auth
        // Setting Listeners for Buttons
        signInButton.setOnClickListener(this)
        //signUpButton.setOnClickListener(this)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
    }

    override fun onClick(v: View?) {
        val email = emailEditText.text.toString()
        val password = passwordEditText.text.toString()
        auth.signInWithEmailAndPassword(email,password).addOnCompleteListener {
            if (it.isSuccessful) {
                startActivity(Intent(this, WelcomeActivity::class.java))
            }
            else {
                Toast.makeText(this, "User not found", Toast.LENGTH_LONG).show()
            }
        }
    }
}