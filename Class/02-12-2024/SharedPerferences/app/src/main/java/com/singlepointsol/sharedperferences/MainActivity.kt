package com.singlepointsol.sharedperferences

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
    lateinit var emailEditText: EditText
    lateinit var passwordEditText: EditText
    lateinit var loadButton: Button
    lateinit var saveButton: Button
    lateinit var sharedPreferences: SharedPreferences
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)

        // Loading View
        emailEditText = findViewById(R.id.email_editText)
        passwordEditText = findViewById(R.id.password_editText)
        loadButton = findViewById(R.id.load_button)
        saveButton = findViewById(R.id.save_button)

        // Setting Listeners
        loadButton.setOnClickListener(this)
        saveButton.setOnClickListener(this)

        // Creation of Shared Preferences File
        sharedPreferences = getSharedPreferences("SinglePointPerfs", MODE_PRIVATE)

        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
    }

    override fun onClick(v: View?) {
        if (v != null) {
            when (v.id) {
                R.id.save_button -> {
                    val editor: SharedPreferences.Editor = sharedPreferences.edit()
                    editor.putString("nameKey", emailEditText.text.toString())
                    editor.putString("passwordKey", passwordEditText.text.toString())
                    editor.apply()
                    emailEditText.text.clear()
                    passwordEditText.text.clear()
                }
                R.id.load_button -> {
                    if (sharedPreferences.contains("nameKey")) {
                        val email: String = sharedPreferences.getString("nameKey", null).toString()
                        emailEditText.setText(email)
                    } else
                    {
                        Toast.makeText(this, "Empty Name Preference", Toast.LENGTH_LONG).show()
                        }
                    if (sharedPreferences.contains("passwordKey")) {
                        val password: String = sharedPreferences.getString("passwordKey", null).toString()
                        passwordEditText.setText(password)
                    }
                    else {
                        Toast.makeText(this, "Empty Password Preference", Toast.LENGTH_LONG).show()
                    }
                }
            }
        }
    }
}