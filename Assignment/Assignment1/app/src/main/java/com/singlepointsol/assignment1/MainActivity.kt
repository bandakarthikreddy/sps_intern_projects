package com.singlepointsol.assignment1

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
    lateinit var nameEditText: EditText
    lateinit var phoneEditText: EditText
    lateinit var emailEditText: EditText
    lateinit var designationEditText: EditText

    lateinit var submitBtn: Button

    lateinit var nametextView: TextView
    lateinit var phonetextView: TextView
    lateinit var emailtextView: TextView
    lateinit var designationtextView: TextView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)
        //loading views into activity
        // val array = arrayOf("R.id.name_et","R.id.phone_et","R.id.email_et","R.id.designation_et")
        nameEditText = findViewById(R.id.name_et)
        phoneEditText = findViewById(R.id.phoneno_et)
        emailEditText = findViewById(R.id.email_et)
        designationEditText= findViewById(R.id.designation_et)

        submitBtn = findViewById(R.id.submit_button)

        nametextView = findViewById(R.id.name_tv)
        phonetextView = findViewById(R.id.phoneno_tv)
        emailtextView = findViewById(R.id.email_tv)
        designationtextView = findViewById(R.id.designation_tv)


        submitBtn.setOnClickListener(View.OnClickListener {

            val name: String = nameEditText.text.toString()
            nametextView.text = name
            nameEditText.setText("")

            val phone: String = phoneEditText.text.toString()
            phonetextView.text = phone
            phoneEditText.setText("")

            val email: String = emailEditText.text.toString()
            emailtextView.text = email
            emailEditText.setText("")

            val designation: String = designationEditText.text.toString()
            designationtextView.text = designation
            designationEditText.setText("")
        })


        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
    }
}