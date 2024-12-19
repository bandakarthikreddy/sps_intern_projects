package com.singlepointsol.pickerdialog

import android.app.DatePickerDialog
import android.app.TimePickerDialog
import android.icu.util.Calendar
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.DatePicker
import android.widget.TimePicker
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class MainActivity : AppCompatActivity(), View.OnClickListener, DatePickerDialog.OnDateSetListener,
    TimePickerDialog.OnTimeSetListener {
    lateinit var timePickerButton: Button
    lateinit var datePickerButton: Button
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)

        // Loading views into activity
        timePickerButton = findViewById(R.id.timePicker_button)
        datePickerButton = findViewById(R.id.datePicker_button)
        // Setting listeners
        timePickerButton.setOnClickListener(this)
        datePickerButton.setOnClickListener(this)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
    }

    override fun onClick(p0: View?) {
        // Use the time as the default values
        val calendar = Calendar.getInstance()
        val hour: Int = calendar.get(Calendar.HOUR_OF_DAY)
        val minute: Int = calendar.get(Calendar.MINUTE)
        val year = calendar.get(Calendar.YEAR)
        val month = calendar.get(Calendar.MONTH)
        val day_of_month = calendar.get(Calendar.DAY_OF_MONTH)
        if (p0 != null) {
            when (p0.id) {
                R.id.timePicker_button -> TimePickerDialog(this, this, hour, minute, false).show()
                R.id.datePicker_button-> DatePickerDialog (this, this, year, month, day_of_month).show()
            }
        }
    }


    override fun onDateSet(p0: DatePicker?, p1: Int, p2: Int, p3: Int) {
        val dateSelected = "${p2+1} / $p3 / $p1 "
        datePickerButton.text = dateSelected
    }

    override fun onTimeSet(p0: TimePicker?, p1: Int, p2: Int) {
        val timeSelected = "$p1 $p2"
        timePickerButton.text = timeSelected
    }
}