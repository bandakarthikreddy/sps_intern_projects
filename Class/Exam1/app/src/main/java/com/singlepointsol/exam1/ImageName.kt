package com.singlepointsol.exam1

import android.annotation.SuppressLint
import android.os.Bundle
import android.widget.ImageView
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class ImageName : AppCompatActivity() {
    lateinit var imageView: ImageView
    lateinit var imageName: TextView

    @SuppressLint("MissingInflatedId")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_image_name)

        // Initialize views
        imageView = findViewById(R.id.image_view)
        imageName = findViewById(R.id.text_view)

        // Get intent data
        val imageView = intent.getIntExtra("imageResource", -1)
        val imageName = intent.getStringExtra("itemClicked")


        // Handle window insets
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
    }
}
