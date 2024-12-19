package com.singlepointsol.assignmentpassingdata

import android.content.Intent
import android.content.SharedPreferences
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.EditText
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class MainActivity : AppCompatActivity(), View.OnClickListener {
    lateinit var nameEditText: EditText
    lateinit var mobileEditText: EditText
    lateinit var emailEditText: EditText
    lateinit var designationEditText: EditText
    lateinit var submitButton: Button
    lateinit var sharedPreferences: SharedPreferences
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)

        // loading views into activity
        nameEditText = findViewById(R.id.name_et)
        mobileEditText = findViewById(R.id.mobile_et)
        emailEditText = findViewById(R.id.email_et)
        designationEditText = findViewById(R.id.designation_et)
        submitButton = findViewById(R.id.submit_button)

        // Setting Listeners
        submitButton.setOnClickListener(this)

        // Creation of Directory for Shared Preferences
        sharedPreferences = getSharedPreferences("")
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
    }

    override fun onClick(p0: View?) {
        val intent: Intent = Intent(this, ProfileDetailsActivity::class.java)
        intent.putExtra("name", nameEditText.text.toString())
        intent.putExtra("mobile", mobileEditText.text.toString())
        intent.putExtra("email", emailEditText.text.toString())
        intent.putExtra("designation", designationEditText.text.toString())
        startActivity(intent)
        when (p0.id) {
            R.id.name_et -> {

            }
            R.id.email_et -> {

            }
            R.id.mobile_et -> {

            }
            R.id.designation_et -> {

            }
        }

    }
}