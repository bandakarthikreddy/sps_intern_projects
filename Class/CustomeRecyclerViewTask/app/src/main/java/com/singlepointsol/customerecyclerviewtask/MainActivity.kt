package com.singlepointsol.customerecyclerviewtask

import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

class MainActivity : AppCompatActivity() {
    lateinit var recycler_view:RecyclerView
    lateinit var fruitsArrayList: ArrayList<Fruits>

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)
        //load recyclerview
        recycler_view=findViewById(R.id.recycler_view)
        //select layout to display the views
        recycler_view.layoutManager= LinearLayoutManager(this)
        fruitsArrayList= ArrayList()
       fruitsArrayList.add(Fruits(R.drawable.apple,  "Apple"))
        fruitsArrayList.add(Fruits(R.drawable.blackberry,"Blackberry"))
        fruitsArrayList.add(Fruits(R.drawable.blueberry,"Blueberry"))
        fruitsArrayList.add(Fruits(R.drawable.cherry,"Cherry"))

        recycler_view.adapter=CustomAdapter(fruitsArrayList)


        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
    }
}