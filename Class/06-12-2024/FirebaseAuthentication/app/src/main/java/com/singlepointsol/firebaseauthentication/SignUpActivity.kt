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
import javax.security.auth.callback.PasswordCallback

class SignUpActivity : AppCompatActivity(), View.OnClickListener {
    // Declaring Globally
    // Edit text
    lateinit var firstNameEditText: EditText
    lateinit var lastNameEditText: EditText
    lateinit var mobileEditText: EditText
    lateinit var emailEditText: EditText
    lateinit var passwordEditText: EditText
    lateinit var confirmpasswordEditText: EditText

    // Button
    lateinit var signUpButton: Button
    lateinit var signInButton: Button

    //
    private lateinit var auth: FirebaseAuth
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_sign_up)
        // Loading Views into Activity
        // Edit Text
        firstNameEditText = findViewById(R.id.firstNameSignUp_editText)
        lastNameEditText = findViewById(R.id.lastNameSignUp_editText)
        mobileEditText = findViewById(R.id.mobileSignUp_editText)
        emailEditText = findViewById(R.id.emailSignUp_editText)
        passwordEditText = findViewById(R.id.passwordSignUp_editText)
        confirmpasswordEditText = findViewById(R.id.confirmpasswordSignUp_editText)

        // Buttons
        signUpButton = findViewById(R.id.signUp_button)
        signInButton = findViewById(R.id.signIn_button)
        // Initialize Firebase Authentication
        auth = Firebase.auth
        // Setting Listeners for Buttons
        signUpButton.setOnClickListener(this)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
    }

    override fun onClick(v: View?) {
        when (v?.id) {
            R.id.signUp_button -> {
                if (firstNameEditText.text.toString()
                        .isNotEmpty() && lastNameEditText.text.toString()
                        .isNotEmpty() && mobileEditText.text.toString()
                        .isNotEmpty() && emailEditText.text.toString()
                        .isNotEmpty() && passwordEditText.text.toString()
                        .isNotEmpty() && confirmpasswordEditText.text.toString().isNotEmpty()
                ) {
                    if (passwordEditText.text.toString() == confirmpasswordEditText.text.toString()) {
                        auth.createUserWithEmailAndPassword(
                            emailEditText.text.toString(),
                            passwordEditText.text.toString()
                        ).addOnCompleteListener {
                            if (it.isSuccessful) {
                                val intent = Intent(this, SignInActivity::class.java)
                                startActivity(intent)
                            } else {
                                Toast.makeText(this, "Unable to SignUp", Toast.LENGTH_LONG).show()
                            }
                        }

                    } else {
                        Toast.makeText(this, "Password does not match", Toast.LENGTH_LONG).show()
                    }
                    firstNameEditText.text.clear()
                    lastNameEditText.text.clear()
                    mobileEditText.text.clear()
                    emailEditText.text.clear()
                    passwordEditText.text.clear()
                    confirmpasswordEditText.text.clear()
                }
            }

            R.id.signIn_button -> {
                startActivity(Intent(this, SignInActivity::class.java))
            }
        }
    }
}
