package com.singlepointsol.customalertdialog

import android.app.AlertDialog
import android.app.Dialog
import android.os.Bundle
import androidx.fragment.app.DialogFragment

class CustomAlertDialog: DialogFragment() {
    override fun onCreateDialog(savedInstanceState: Bundle?): Dialog {
        val builder = AlertDialog.Builder(context)
        builder.setView(R.layout.customalertdialog)
        return builder.create()
    }
}