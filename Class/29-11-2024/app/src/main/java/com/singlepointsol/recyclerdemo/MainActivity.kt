package com.singlepointsol.recyclerdemo

import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

class MainActivity : AppCompatActivity() {
    lateinit var recyclerView: RecyclerView
    var versionsArray = arrayOf("Baklava", "Vanilla Ice Cream", "Upside Down Cake", "Tiramisu", "Snow Cone", "Red Velvet Cake", "Quince Tart", "Pistachio Ice Cream", "Oatmeal Cookie", "New York Cheesecake", "Macadamia Nut Cookie", "Lemon Meringue Pie", "Key Lime Pie", "Jelly Bean", "Ice Cream Sandwich", "Honeycomb", "Gingerbread", "Froyo", "Eclair", "Donut", "Cupcake","Petit Four"
    ,"Baklava", "Vanilla Ice Cream", "Upside Down Cake", "Tiramisu", "Snow Cone", "Red Velvet Cake", "Quince Tart", "Pistachio Ice Cream", "Oatmeal Cookie", "New York Cheesecake", "Macadamia Nut Cookie", "Lemon Meringue Pie", "Key Lime Pie", "Jelly Bean", "Ice Cream Sandwich", "Honeycomb", "Gingerbread", "Froyo", "Eclair", "Donut", "Cupcake","Petit Four",
        "Baklava", "Vanilla Ice Cream", "Upside Down Cake", "Tiramisu", "Snow Cone", "Red Velvet Cake", "Quince Tart", "Pistachio Ice Cream", "Oatmeal Cookie", "New York Cheesecake", "Macadamia Nut Cookie", "Lemon Meringue Pie", "Key Lime Pie", "Jelly Bean", "Ice Cream Sandwich", "Honeycomb", "Gingerbread", "Froyo", "Eclair", "Donut", "Cupcake","Petit Four")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)
        // Loading views into activity
        recyclerView = findViewById(R.id.recycler_view)
        recyclerView.layoutManager = LinearLayoutManager(this)
        recyclerView.adapter = VersionsAdapter(versionsArray)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
    }
}