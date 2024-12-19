package com.singlepointsol.assignmentpassingdata

import android.content.Intent
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class ProfileDetailsActivity : AppCompatActivity(), View.OnClickListener {
    lateinit var nameTextView: TextView
    lateinit var mobileTextView: TextView
    lateinit var emailTextView: TextView
    lateinit var designationTextView: TextView
    lateinit var homeButton: Button
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_profile_details)

        // Loading views into activity
        nameTextView = findViewById(R.id.name_tv)
        mobileTextView = findViewById(R.id.mobile_tv)
        emailTextView = findViewById(R.id.email_tv)
        designationTextView = findViewById(R.id.designation_tv)
        homeButton = findViewById(R.id.home_button)

        // Reading values from Main Activity to Profile Details Activity
        val name:String = intent.getStringExtra("name").toString()
        nameTextView.text = name
        val mobile:String = intent.getStringExtra("mobile").toString()
        mobileTextView.text = mobile
        val email:String = intent.getStringExtra("email").toString()
        emailTextView.text = email
        val designation:String = intent.getStringExtra("designation").toString()
        designationTextView.text = designation

        //Setting Listeners
        homeButton.setOnClickListener(this)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
    }

    override fun onClick(p0: View?) {
        val homeIntent: Intent = Intent(this, MainActivity::class.java)
        startActivity(homeIntent)
    }
}