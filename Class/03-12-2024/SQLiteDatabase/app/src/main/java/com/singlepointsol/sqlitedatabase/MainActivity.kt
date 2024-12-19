package com.singlepointsol.sqlitedatabase

import android.content.Intent
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class MainActivity : AppCompatActivity(), View.OnClickListener {
    // Declaring Globally
    // Edit Text
    private lateinit var nameEditText: EditText
    private lateinit var emailEditText: EditText
    private lateinit var mobileEditText: EditText
    // Buttons
    private lateinit var deleteButton: Button
    private lateinit var updateButton: Button
    private lateinit var loadButton: Button
    private lateinit var saveButton: Button
    // Edit Text
    lateinit var colIdEdit: EditText

    lateinit var employeeDBHelper: EmployeeDBHelper
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)
        // Loading Views into Activity
        // Edit Text
        nameEditText = findViewById(R.id.name_editText)
        emailEditText = findViewById(R.id.email_editText)
        mobileEditText = findViewById(R.id.mobile_editText)
        // Buttons
        deleteButton = findViewById(R.id.delete_button)
        updateButton = findViewById(R.id.update_button)
        loadButton = findViewById(R.id.load_button)
        saveButton = findViewById(R.id.save_button)
        //Edit Text
        colIdEdit = findViewById(R.id.colId_edittext)

        // Setting listeners
        // Edit Text
        /*nameEditText.setOnClickListener(this)
        emailEditText.setOnClickListener(this)
        mobileEditText.setOnClickListener(this)

         */
        // Buttons
        deleteButton.setOnClickListener(this)
        updateButton.setOnClickListener(this)
        loadButton.setOnClickListener(this)
        saveButton.setOnClickListener(this)

        employeeDBHelper = EmployeeDBHelper(this)

        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
    }


    override fun onClick(v: View?) {
        when (v?.id) {
            R.id.save_button -> {
                if (nameEditText.text.isNotEmpty() && emailEditText.text.isNotEmpty() && mobileEditText.text.isNotEmpty()) {
                    val employee = Employee(nameEditText.text.toString(), emailEditText.text.toString(), mobileEditText.text.toString())
                    val result: Long = employeeDBHelper.addEmployee(employee)
                    if (result >= -1) {
                        Toast.makeText(applicationContext, "Data Inserted", Toast.LENGTH_LONG).show()
                        nameEditText.text.clear()
                        emailEditText.text.clear()
                        mobileEditText.text.clear()
                    }
                }
                else {
                    Toast.makeText(applicationContext, "Name or Email or Mobile cannot be blank", Toast.LENGTH_LONG).show()
                }
            }
            R.id.load_button -> {
                val intent = Intent(this, EmployeeDetails::class.java)
                startActivity(intent)
            }
            R.id.update_button -> {
                val isUpdated: Boolean = employeeDBHelper.updateEmployee(colIdEdit.text.toString(),nameEditText.text.toString(), emailEditText.text.toString(), mobileEditText.text.toString())
                if (isUpdated) {
                    Toast.makeText(applicationContext, "Data Updated!", Toast.LENGTH_LONG).show()
                }
                else
                {
                    Toast.makeText(applicationContext, "Data Not Found", Toast.LENGTH_LONG).show()
                }
            }
            R.id.delete_button -> {
                val rows = employeeDBHelper.deleteEmployee(colIdEdit.text.toString())
                if (rows > 0 ) {
                    Toast.makeText(applicationContext, "Data Deleted Successfully", Toast.LENGTH_LONG).show()
                }
                else {
                    Toast.makeText(applicationContext, "Data Not Found", Toast.LENGTH_LONG).show()
                }
            }
        }
    }
}

