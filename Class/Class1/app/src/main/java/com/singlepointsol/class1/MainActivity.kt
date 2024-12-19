package com.singlepointsol.class1

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
    private lateinit var changeTextButton: Button
    private lateinit var textView: TextView
    private lateinit var image: Button
    private lateinit var buttonColor: Button
    private lateinit var parentLayout: ConstraintLayout
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)

        changeTextButton = findViewById(R.id.changeText_button)
        textView = findViewById(R.id.text_view)
        image = findViewById(R.id.image_button)
        buttonColor = findViewById(R.id.color_button)
        parentLayout = findViewById(R.id.main)

        changeTextButton.setOnClickListener(this)
        image.setOnClickListener(this)
        buttonColor.setOnClickListener(this)
        parentLayout.setOnClickListener(this)
        textView.setOnClickListener(this)

        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
    }

    @SuppressLint("SetTextI18n")
    override fun onClick(p0: View?) {
        if(p0 != null) {
            when (p0.id) {
                R.id.changeText_button -> textView.text = "Change text from the Main Activity File"
                R.id.image_button -> parentLayout.setBackgroundResource(R.drawable.bike)
                R.id.color_button -> buttonColor.setBackgroundColor(getColor(R.color.black))
            }
        }
    }
}