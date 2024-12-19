package com.singlepointsol.journeydetails

import android.app.DatePickerDialog
import android.app.TimePickerDialog
import android.content.Intent
import android.icu.util.Calendar
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.DatePicker
import android.widget.EditText
import android.widget.TimePicker
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class MainActivity : AppCompatActivity(), View.OnClickListener,
    DatePickerDialog.OnDateSetListener, TimePickerDialog.OnTimeSetListener {

    lateinit var sourceLocation: EditText
    lateinit var destinationLocation: EditText
    lateinit var dateButton: Button
    lateinit var timeButton: Button
    lateinit var submitButton: Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        // Loading views into activity
        sourceLocation = findViewById(R.id.sourceLocation_et)
        destinationLocation = findViewById(R.id.destinationLocation_et)
        dateButton = findViewById(R.id.dateButton)
        timeButton = findViewById(R.id.timeButton)
        submitButton = findViewById(R.id.submit_button)

        // Set default text for date and time buttons
        //dateButton.text = getString(R.string.select_date)
        timeButton.text = getString(R.string.select_time)

        // Setting Listeners
        dateButton.setOnClickListener(this)
        timeButton.setOnClickListener(this)
        submitButton.setOnClickListener(this)

        // Adjust for system bars
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
    }

    override fun onClick(view: View?) {
        val calendar = Calendar.getInstance()
        val year = calendar.get(Calendar.YEAR)
        val month = calendar.get(Calendar.MONTH)
        val day = calendar.get(Calendar.DAY_OF_MONTH)
        val hour = calendar.get(Calendar.HOUR_OF_DAY)
        val minute = calendar.get(Calendar.MINUTE)

        when (view?.id) {
            R.id.dateButton -> {
                // Show DatePickerDialog
                DatePickerDialog(this, this, year, month, day).show()
            }

            R.id.timeButton -> {
                // Show TimePickerDialog
                TimePickerDialog(this, this, hour, minute, true).show()
            }

            R.id.submit_button -> {
                if (sourceLocation.text.toString().isEmpty() || destinationLocation.text.toString()
                        .isEmpty()
                ) {
                    Toast.makeText(this, "Enter the details", Toast.LENGTH_LONG).show()
                } else if (dateButton.text.toString() == getString(R.string.select_date)) {
                    Toast.makeText(this, "Select Date", Toast.LENGTH_LONG).show()
                } else if (timeButton.text.toString() == "Select Time") {
                    Toast.makeText(this, "Select Time", Toast.LENGTH_LONG).show()
                } else {
                    // Handle submit button click
                    val submitIntent = Intent(this, JourneyDetails::class.java)
                    submitIntent.putExtra("source", sourceLocation.text.toString())
                    submitIntent.putExtra("destination", destinationLocation.text.toString())
                    submitIntent.putExtra("date", dateButton.text.toString())
                    submitIntent.putExtra("time", timeButton.text.toString())
                    startActivity(submitIntent)
                }
            }
        }
    }

    override fun onDateSet(p0: DatePicker?, year: Int, month: Int, day: Int) {
        val dateSelected = "$year/${month + 1}/$day"
        dateButton.text = dateSelected
    }

    override fun onTimeSet(p0: TimePicker?, hour: Int, minute: Int) {
        val timeSelected = "$hour:$minute"
        timeButton.text = timeSelected
    }
}
