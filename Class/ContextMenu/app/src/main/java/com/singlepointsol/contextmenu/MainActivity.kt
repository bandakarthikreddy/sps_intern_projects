package com.singlepointsol.contextmenu

import android.os.Bundle
import android.view.ContextMenu
import android.view.MenuInflater
import android.view.MenuItem
import android.view.View
import android.widget.Button
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import androidx.constraintlayout.widget.ConstraintLayout
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class MainActivity : AppCompatActivity() {
    lateinit var contextButton: Button
    lateinit var contextTextView: TextView
    lateinit var parentLayout: ConstraintLayout

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        // Initializing views
        contextButton = findViewById(R.id.context_button)
        contextTextView = findViewById(R.id.context_tv)
        parentLayout = findViewById(R.id.main)

        // Setting window insets
        ViewCompat.setOnApplyWindowInsetsListener(parentLayout) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        // Registering views for context menu
        registerForContextMenu(contextButton)
        registerForContextMenu(contextTextView)
    }



    override fun onCreateContextMenu(
        menu: ContextMenu?,
        v: View?,
        menuInfo: ContextMenu.ContextMenuInfo?
    ) {
        super.onCreateContextMenu(menu, v, menuInfo)
        /*
        Inflating the context menu
        Two lines of code
        val inflater: MenuInflater = menuInflater
        inflater.inflate(R.menu.content_menu,menu)
        */
        // One line of code
        menuInflater.inflate(R.menu.content_menu, menu)
    }

    override fun onContextItemSelected(item: MenuItem): Boolean {
        return when (item.itemId) {
            R.id.item_text -> {
                // Updating text on contextTextView
                val updatedtext = "Welcome to Single Point Sol"
                contextTextView.text = updatedtext
                true
            }
            R.id.color_item -> {
                // Changing button background color
                contextButton.setBackgroundColor(getColor(R.color.context))
                true
            }
            R.id.background_item -> {
                // Changing parent layout background
                parentLayout.setBackgroundResource(R.drawable.android)
                true
            }
            else -> super.onContextItemSelected(item)
        }
    }
}
