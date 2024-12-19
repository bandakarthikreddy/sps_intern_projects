package com.singlepointsol.recyclergrid

import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.RecyclerView

class MainActivity : AppCompatActivity() {
    lateinit var recyclerView: RecyclerView
    val versionsImageArray = arrayOf(R.drawable.baseline, R.drawable.baseline1, R.drawable.baseline_2)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)
        //Loading views into activity
        recyclerView = findViewById(R.id.recycler_view)
        // Layout Manager
        recyclerView.layoutManager = GridLayoutManager(this, 2)
        // Adapter
        recyclerView.adapter = VersionsImagesAdapter(versionsImageArray)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
    }
}