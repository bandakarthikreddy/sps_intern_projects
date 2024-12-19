package com.singlepointsol.pickerdialog

import android.app.DatePickerDialog
import android.app.Dialog
import android.app.TimePickerDialog
import android.icu.util.Calendar
import android.os.Bundle
import android.widget.DatePicker
import android.widget.TimePicker
import androidx.fragment.app.DialogFragment

class TimePickerFragment(
    mainActivity: MainActivity,
    mainActivity1: MainActivity,
    hour: Int,
    minute: Int
) : DialogFragment(), TimePickerDialog.OnTimeSetListener,
    DatePickerDialog.OnDateSetListener {
    override fun onCreateDialog(savedInstanceState: Bundle?): Dialog {
        // Use the time as the default values
        val calendar = Calendar.getInstance()
        val hour: Int = calendar.get(Calendar.HOUR_OF_DAY)
        val minute: Int = calendar.get(Calendar.MINUTE)
        val year = calendar.get(Calendar.YEAR)
        val month = calendar.get(Calendar.MONTH)
        val day_of_month = calendar.get(Calendar.DAY_OF_MONTH)

        return TimePickerDialog(context, this, hour, minute, true)
        //return DatePickerDialog(this, this, year, month, day_of_month)
    }

    override fun onTimeSet(p0: TimePicker?, hour: Int, minute: Int) {
        val timeSelected = "$hour $minute"
    }

    override fun onDateSet(p0: DatePicker?, p1: Int, p2: Int, p3: Int) {
    }

    fun show() {
        TODO("Not yet implemented")
    }
}