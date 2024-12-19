package com.singlepointsol.a05intlothreebuttonsbackgroundimage

import android.annotation.SuppressLint
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.constraintlayout.widget.ConstraintLayout
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class MainActivity : AppCompatActivity(), View.OnClickListener {

    // Global Variable
    lateinit var morningButton: Button
    lateinit var eveningButton: Button
    lateinit var nightButton: Button
    lateinit var parentLayout: ConstraintLayout
    lateinit var textButton: Button
    lateinit var textView: TextView

    @SuppressLint("MissingInflatedId")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)

        // Loading views into Activity
        morningButton = findViewById(R.id.morning_button)
        eveningButton = findViewById(R.id.evening_button)
        nightButton = findViewById(R.id.night_button)
        parentLayout = findViewById(R.id.main)
        textButton = findViewById(R.id.text_button)
        textView = findViewById(R.id.text_tv)


        /*
        morningButton.setOnClickListener(View.OnClickListener {
            parentLayout.setBackgroundResource(R.drawable.good_morning)
        })

        eveningButton.setOnClickListener(View.OnClickListener {
            parentLayout.setBackgroundResource(R.drawable.good_evening)
        })

        nightButton.setOnClickListener(View.OnClickListener {
            parentLayout.setBackgroundResource(R.drawable.good_night)
        })

        textButton.setOnClickListener(View.OnClickListener {
            val text: String = "This is entered in text view"
            textView.text = text
 */

        morningButton.setOnClickListener(this)
        eveningButton.setOnClickListener(this)
        nightButton.setOnClickListener(this)
        textButton.setOnClickListener(this)
        textView.setOnClickListener(this)


        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
    }


    override fun onClick(p0: View?) {
        if (p0 != null) {
            when (p0.id) {
                R.id.morning_button -> parentLayout.setBackgroundResource(R.drawable.good_morning)
                R.id.evening_button -> parentLayout.setBackgroundResource(R.drawable.good_evening)
                R.id.night_button -> parentLayout.setBackgroundResource(R.drawable.good_night)
                R.id.text_button -> textView.text = "Change text from the Main Activity File"
            }
        }
    }
}