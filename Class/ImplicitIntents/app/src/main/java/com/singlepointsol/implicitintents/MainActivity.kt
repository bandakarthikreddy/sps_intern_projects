package com.singlepointsol.implicitintents

import android.annotation.SuppressLint
import android.content.Intent
import android.net.Uri
import android.os.Bundle
import android.view.View
import android.widget.Button
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class MainActivity : AppCompatActivity(), View.OnClickListener {
    lateinit var callButton: Button
    lateinit var dialButton: Button
    lateinit var browseButton: Button
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)

        // Loading views into activity
        callButton = findViewById(R.id.call_button)
        dialButton = findViewById(R.id.dial_button)
        browseButton = findViewById(R.id.browse_button)

        // Setting Listeners
        callButton.setOnClickListener(this)
        dialButton.setOnClickListener(this)
        browseButton.setOnClickListener(this)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
    }


    override fun onClick(view: View?) {
        if (view != null) {
        when (view.id) {
            R.id.call_button -> {
                val callIntent = Intent (Intent.ACTION_CALL, Uri.parse("tel: 9121655836"))
                startActivity(callIntent)
            }
            R.id.dial_button -> {
                val dialIntent = Intent (Intent.ACTION_DIAL, Uri.parse("tel: 9121655836"))
                startActivity(dialIntent)
            }
            R.id.browse_button -> {
                val browseIntent = Intent (Intent.ACTION_VIEW).apply {
                    data = Uri.parse("https://www.google.co.in")
                }
                startActivity(browseIntent)
            }
            }
        }
    }
}