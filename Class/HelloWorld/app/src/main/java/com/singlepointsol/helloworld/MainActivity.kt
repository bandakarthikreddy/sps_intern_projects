package com.singlepointsol.helloworld

import android.os.Bundle
import android.util.Log
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class MainActivity : AppCompatActivity() {
    // Declaring Global Variables
    private val tag: String = "Activity Life Cycle"
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)
        // Activity Life Cycle for onCreate
        // Log is imported
        // tag is declared in Global Variable
        Log.e(tag, "I am in onCreate()")
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
    }

    // Activity Life Cycle for onStart
    override fun onStart() {
        super.onStart()
        Log.e(tag, "I am in onStart()")
    }

    // Activity Life Cycle for onPause
    override fun onPause() {
        super.onPause()
        Log.e(tag, "I am in onPause()")
    }

    // Activity Life Cycle for onResume
    override fun onResume() {
        super.onResume()
        Log.e(tag,"I am in onResume()")
    }

    // Activity Life Cycle for onStop
    override fun onStop() {
        super.onStop()
        Log.e(tag, "I am in onStop()")
    }

    // Activity Life Cycle for onDestroy
    override fun onDestroy() {
        super.onDestroy()
        Log.e(tag, "I am in onDestroy()")
    }

    // Activity Life Cycle for onRestart
    override fun onRestart() {
        super.onRestart()
        Log.e(tag, "I am in onRestart()")
    }
}