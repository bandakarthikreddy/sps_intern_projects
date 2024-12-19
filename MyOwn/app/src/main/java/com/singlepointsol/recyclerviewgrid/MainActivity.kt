package com.singlepointsol.recyclerviewgrid

import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

class MainActivity : AppCompatActivity() {
    // Declaring Recycler View
    lateinit var recyclerView: RecyclerView
    val textImage = findViewById<RecyclerView>(R.id.recycler_view)

    val textImageArray = arrayListOf()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)
        // Loading Views into Activity
        recyclerView = findViewById(R.id.recycler_view)
        // Setting Layout
        recyclerView.layoutManager = LinearLayoutManager(this)
        // Setting Adapter
        recyclerView.adapter = TextImage()
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
    }
}