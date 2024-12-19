package com.singlepointsol.passingdata

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
    lateinit var sendButton: Button
    lateinit var EditText: EditText
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)
        // loading views into activity
        sendButton = findViewById(R.id.send_button)
        EditText = findViewById(R.id.data_et)
        // Setting listeners
        sendButton.setOnClickListener(this)
        //EditText.setOnClickListener(this)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
    }

    override fun onClick(v: View?) {
        if (EditText.text.isNotEmpty()) {
            val intent = Intent(this, DetailsActivity::class.java)
            intent.putExtra("data", EditText.text.toString())
            startActivity(intent)
        } else {
            Toast.makeText(this, "Enter the value", Toast.LENGTH_LONG).show()
        }
    }
}