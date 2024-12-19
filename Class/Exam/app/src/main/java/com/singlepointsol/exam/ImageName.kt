package com.singlepointsol.exam

import android.os.Bundle
import android.widget.ImageView
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity

class ImageName : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_image_name)

        // Load passed data
        val carName = intent.getStringExtra("carName")
        val carImage = intent.getIntExtra("carImage", 0)

        // Set data to views
        val carImageView: ImageView = findViewById(R.id.image_view)
        val carNameTextView: TextView = findViewById(R.id.text_view)

        carImageView.setImageResource(carImage)
        carNameTextView.text = carName
    }
}
