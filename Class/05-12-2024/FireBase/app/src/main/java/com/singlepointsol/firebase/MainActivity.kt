package com.singlepointsol.firebase

import android.content.Intent
import android.os.Bundle
import android.provider.ContactsContract.CommonDataKinds.Email
import android.view.View
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.google.firebase.Firebase
import com.google.firebase.database.DatabaseReference
import com.google.firebase.database.FirebaseDatabase
import com.google.firebase.database.database

class MainActivity : AppCompatActivity(), View.OnClickListener {
    // Declaring Globally
    // Edit Text
    private lateinit var nameEditText: EditText
    private lateinit var emailEditText: EditText
    private lateinit var mobileEditText: EditText
    private lateinit var designationEditText: EditText
    // Buttons
    private lateinit var saveButton: Button
    private lateinit var loadButton: Button
    // Firebase
    private lateinit var database: FirebaseDatabase
    // Reference Firebase
    private lateinit var databasereference: DatabaseReference

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)
        // Loading Views into Activity
        // Edit Text
        nameEditText = findViewById(R.id.name_editText)
        emailEditText = findViewById(R.id.email_editText)
        mobileEditText = findViewById(R.id.phone_editText)
        designationEditText = findViewById(R.id.designation_editText)
        // Buttons
        saveButton = findViewById(R.id.save_button)
        loadButton = findViewById(R.id.load_button)
        // Setting Listeners for Buttons
        saveButton.setOnClickListener(this)
        loadButton.setOnClickListener(this)

        // Firebase
        database = Firebase.database
        // Reference for Firebase
        databasereference = database.reference.child("Employees")
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
    }

    override fun onClick(v: View?) {
        when (v?.id) {
            R.id.save_button -> {
                if (nameEditText.text.toString().isNotEmpty() && emailEditText.text.toString().isNotEmpty() && mobileEditText.text.toString().isNotEmpty() && designationEditText.text.toString().isNotEmpty()) {
                    val employee = Employees(nameEditText.text.toString(), emailEditText.text.toString(), mobileEditText.text.toString(), designationEditText.text.toString())
                    databasereference.push().setValue(employee)
                    Toast.makeText(applicationContext, "Data Inserted", Toast.LENGTH_LONG).show()
                    nameEditText.text.clear()
                    emailEditText.text.clear()
                    mobileEditText.text.clear()
                    designationEditText.text.clear()
                }
            }
            R.id.load_button -> {
                val intent = Intent(this, EmployeeDetailsActivity::class.java)
                startActivity(intent)
            }
        }
    }
}