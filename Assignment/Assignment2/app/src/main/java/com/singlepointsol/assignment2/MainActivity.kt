package com.singlepointsol.assignment2

import android.os.Bundle
import android.service.autofill.OnClickAction
import android.view.View
import android.widget.Button
import android.widget.ImageButton
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.constraintlayout.widget.ConstraintLayout
import androidx.core.graphics.toColorFilter
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class MainActivity : AppCompatActivity() {
    lateinit var clickButton: Button
    lateinit var parentLayout: ConstraintLayout
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)
        // loading of background in
        clickButton = findViewById(R.id.click_button)
        parentLayout = findViewById(R.id.main)
        clickButton.setOnClickListener(View.OnClickListener {
            parentLayout.setBackgroundResource(R.color.white)
        })
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
    }
}