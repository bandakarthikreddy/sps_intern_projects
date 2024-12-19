package com.singlepointsol.carsexam

import android.os.Bundle
import android.widget.ImageView
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class CarsDetailActivity : AppCompatActivity() {
    lateinit var selectedimage: ImageView
    lateinit var name_tv: TextView
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_car_details)
        selectedimage=findViewById(R.id.selected_imageView)
        name_tv=findViewById(R.id.nametextview)
        val imagePosition=intent.getIntExtra("carImage",100)
        selectedimage.setImageResource(imagePosition)
        name_tv.text=intent.getStringExtra("carName")

        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
    }
}
