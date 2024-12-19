package com.singlepointsol.examassignment

import android.os.Bundle
import android.widget.ImageView
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class CarDetailActivity : AppCompatActivity() {
    lateinit var carsImageView: ImageView
    lateinit var carsTextView: TextView
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_car_detail)
        // Loading Views
        carsImageView = findViewById(R.id.cars_imageView)
        carsTextView = findViewById(R.id.cars_textView)

        val imagePosition = intent.getIntExtra("carImage", 100)
        carsImageView.setImageResource(imagePosition)

        carsTextView.text = intent.getStringExtra("carName")
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
    }
}