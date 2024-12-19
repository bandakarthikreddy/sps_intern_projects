package com.singlepointsol.glidedemo

import android.os.Bundle
import android.widget.ImageView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.bumptech.glide.Glide

class MainActivity : AppCompatActivity() {
    lateinit var sampleImageView: ImageView
    lateinit var sample1ImageView: ImageView
    lateinit var sample2ImageView: ImageView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)
        sampleImageView = findViewById(R.id.sample_imageView)
        sample1ImageView = findViewById(R.id.sample1_imageView)
        sample2ImageView = findViewById(R.id.sample2_imageView)

        val imageURL = "data:image/jpeg;base64,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"
        Glide.with(this).load(imageURL).into(sampleImageView)
        val imageURL1 = "data:image/jpeg;base64,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"
        Glide.with(this).load(imageURL1).into(sample1ImageView)
        val imageURl2 = "data:image/jpeg;base64,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"
        Glide.with(this).load(imageURl2).into(sample2ImageView)

        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
    }
}
