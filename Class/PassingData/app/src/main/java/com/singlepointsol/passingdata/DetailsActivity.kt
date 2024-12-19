package com.singlepointsol.passingdata

import android.annotation.SuppressLint
import android.content.Intent
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class DetailsActivity : AppCompatActivity(), View.OnClickListener {
    lateinit var homeButton: Button
    lateinit var textView: TextView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_details)
        // loading views into activity
        homeButton = findViewById(R.id.home_button)
        textView = findViewById(R.id.entereddata_tv)
        // Setting listeners

        val myValue: String = intent.getStringExtra("data").toString()
        textView.text = myValue

        homeButton.setOnClickListener(this)

        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
    }

    override fun onClick(v: View?) {
        val homeintent: Intent = Intent( this, MainActivity::class.java)
        startActivity(homeintent)
    }
}