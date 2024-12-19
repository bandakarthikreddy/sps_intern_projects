package com.singlepointsol.journeydetails

import android.content.Intent
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class JourneyDetails : AppCompatActivity(), View.OnClickListener {
    lateinit var sourceLocationTextView: TextView
    lateinit var destinationLocationTextView: TextView
    lateinit var travellingDateTextView: TextView
    lateinit var travellingTimeTextView: TextView
    lateinit var homeButton: Button
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_journey_details)

        //Loading view into activity
        sourceLocationTextView = findViewById(R.id.source_tv)
        destinationLocationTextView = findViewById(R.id.destination_tv)
        travellingDateTextView = findViewById(R.id.travellingDate_tv)
        travellingTimeTextView = findViewById(R.id.travellingTime_tv)
        homeButton = findViewById(R.id.homeButton)

        val source: String = intent.getStringExtra("source").toString()
        sourceLocationTextView.text = source

        val destination = intent.getStringExtra("destination").toString()
        destinationLocationTextView.text = destination

        val date = intent.getStringExtra("date").toString()
        travellingDateTextView.text = date

        val time = intent.getStringExtra("time").toString()
        travellingTimeTextView.text = time

        //Setting Listeners
        homeButton.setOnClickListener(this)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
    }

    override fun onClick(p0: View?) {
        val homeIntent = Intent (this, MainActivity::class.java)
        startActivity(homeIntent)
    }
}