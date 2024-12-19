package com.singlepointsol.carsimplicitintent

import android.content.Intent
import android.net.Uri
import android.os.Bundle
import android.view.View
import android.widget.Button
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class MainActivity : AppCompatActivity(), View.OnClickListener {
    // Declaring Global Variables
    lateinit var hyundaiButton: Button
    lateinit var nexaButton: Button
    lateinit var mercedesButton: Button
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)
        // Loading Views into Activity
        hyundaiButton = findViewById(R.id.hyundai_button)
        nexaButton  = findViewById(R.id.nexa_button)
        mercedesButton = findViewById(R.id.mercedes_button)

        // Setting Listeners for Buttons
        hyundaiButton.setOnClickListener(this)
        nexaButton.setOnClickListener(this)
        mercedesButton.setOnClickListener(this)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
    }

    override fun onClick(v: View?) {
        when(v?.id) {
            R.id.hyundai_button -> {
                val hyundaiIntent = Intent(Intent.ACTION_VIEW, Uri.parse("https://www.hyundai.com/in/en"))
                startActivity(hyundaiIntent)
            }
            R.id.nexa_button -> {
                val nexaIntent = Intent(Intent.ACTION_VIEW, Uri.parse("https://www.nexaexperience.com/"))
                startActivity(nexaIntent)
            }
            R.id.mercedes_button -> {
                val mercedesIntent = Intent(Intent.ACTION_VIEW, Uri.parse("https://www.mercedes-benz.co.in/"))
                startActivity(mercedesIntent)
            }
        }
    }
}