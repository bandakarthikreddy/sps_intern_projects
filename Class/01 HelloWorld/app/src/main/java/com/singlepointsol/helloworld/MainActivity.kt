package com.singlepointsol.helloworld

import android.os.Bundle
import android.util.Log
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import kotlin.math.log

class MainActivity : AppCompatActivity() {
    private val tag: String = "Activity Life Cycle"
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)
        Log.e(tag, "I am in onCreate()")
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
    }

    override fun onStart() {
        super.onStart()
        Log.e(tag, "I am in onStart()")
    }
    override fun onPause() {
        super.onPause()
        Log.e(tag, "I am in onPause()")
    }
    override fun onResume() {
        super.onResume()
        Log.e(tag, "I am in onResume()")
    }
    override fun onStop() {
        super.onStop()
        Log.e(tag, "I am in onStop()")
    }
    override fun onDestroy() {
        super.onDestroy()
        Log.e(tag, "I am in onDestroy()")
    }
    override fun onRestart() {
        super.onRestart()
        Log.e(tag, "I am in onRestart()")
    }
}