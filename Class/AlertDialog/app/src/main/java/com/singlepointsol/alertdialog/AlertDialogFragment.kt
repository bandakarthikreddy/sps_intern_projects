package com.singlepointsol.alertdialog

import android.app.AlertDialog
import android.app.Dialog
import android.os.Bundle
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.fragment.app.DialogFragment

class AlertDialogFragment: DialogFragment() {
    override fun onCreateDialog(savedInstanceState: Bundle?): Dialog {
        // Creating a valuable with builder and stores the AlertDialog.Builder
        val builder = AlertDialog.Builder(context)

        // Set the title for Alert Dialog
        builder.setTitle("Erase data?")
        // Set the message for the Alert Dialog
        builder.setMessage("All data will be deleted")
        // Set the positive button for Alert Dialog
        builder.setPositiveButton("Erase") { dialog, id ->
            Toast.makeText(context, "Media deleted successfully", Toast.LENGTH_LONG).show()
        }
        // Set the negative button for Alert Dialog
        builder.setNegativeButton("Cancel") { dialog, id ->
            Toast.makeText(context, "Cancel the alert", Toast.LENGTH_LONG).show()
        }

        return builder.create()
    }
}


