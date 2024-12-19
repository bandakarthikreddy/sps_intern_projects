package com.singlepointsol.a03intlopassingedittexttotextvalue

import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class MainActivity : AppCompatActivity() {

    // Global Declaration
    lateinit var nameEditText: EditText
    lateinit var mobileEditText: EditText
    lateinit var emailEditText: EditText
    lateinit var designationEditText: EditText

    lateinit var submitButton: Button

    lateinit var nameTextView: TextView
    lateinit var mobileTextView: TextView
    lateinit var emailTextView: TextView
    lateinit var designationTextView: TextView
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)
        // Loading views into Activity
        nameEditText = findViewById(R.id.name_et)
        mobileEditText = findViewById(R.id.mobile_et)
        emailEditText = findViewById(R.id.email_et)
        designationEditText = findViewById(R.id.designation_et)

        submitButton = findViewById(R.id.submit_button)

        nameTextView = findViewById(R.id.name_tv)
        mobileTextView = findViewById(R.id.mobile_tv)
        emailTextView = findViewById(R.id.email_tv)
        designationTextView = findViewById(R.id.designation_tv)
        // Setting Listeners

        submitButton.setOnClickListener(View.OnClickListener {
            val name: String =nameEditText.text.toString()
            nameTextView.text = name
            nameEditText.setText("")

            val mobile: String =mobileEditText.text.toString()
            mobileTextView.text = mobile
            mobileEditText.setText("")

            val email: String =emailEditText.text.toString()
            emailTextView.text = email
            emailEditText.setText("")

            val designation:String =designationEditText.text.toString()
            designationTextView.text = designation
            designationEditText.setText("")
        })
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
    }
}