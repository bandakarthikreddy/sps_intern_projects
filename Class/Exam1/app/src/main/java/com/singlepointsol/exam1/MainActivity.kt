package com.singlepointsol.exam

import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.singlepointsol.exam1.R

class MainActivity : AppCompatActivity() {
    lateinit var recyclerView: RecyclerView
    lateinit var carsArrayList:ArrayList<Cars>
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)
        //Loading Views
        recyclerView = findViewById(R.id.recycler_view)
        // Layout Manager
        recyclerView.layoutManager = LinearLayoutManager(this)
        // Declaring Array
        carsArrayList = ArrayList()
        carsArrayList.add(Cars(R.drawable.creta,"Hyundai Creta"))
        carsArrayList.add(Cars(R.drawable.i10,"Hyundai i10"))
        carsArrayList.add(Cars(R.drawable.i30,"Hyundai i30"))
        carsArrayList.add(Cars(R.drawable.kona,"Hyundai Kona"))
        carsArrayList.add(Cars(R.drawable.santro,"Hyundai Santro"))
        carsArrayList.add(Cars(R.drawable.venue,"Hyundai Venue"))



        // Adapter
        recyclerView.adapter = CarsAdapter(carsArrayList)

        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
    }
}