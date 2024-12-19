package com.singlepointsol.camerademo

import android.content.Intent
import android.graphics.Bitmap
import android.os.Bundle
import android.provider.MediaStore
import android.view.View
import android.widget.Button
import android.widget.ImageButton
import android.widget.ImageView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class MainActivity : AppCompatActivity(), View.OnClickListener {
    lateinit var cameraButton: Button
    lateinit var capturedImageView: ImageView
    var REQUEST_CODE = 10000
    lateinit var cameraImageButton: ImageButton
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)
        cameraButton = findViewById(R.id.camera_button)
        capturedImageView = findViewById(R.id.camera_imageView)
        cameraImageButton = findViewById(R.id.camera_imageButton)
        cameraButton.setOnClickListener(this)
        cameraImageButton.setOnClickListener(this)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
    }

    override fun onClick(v: View?) {
        /*
        val intent = Intent (MediaStore.ACTION_IMAGE_CAPTURE)
        startActivityForResult(intent, REQUEST_CODE)
        */
        val intent = Intent (MediaStore.ACTION_IMAGE_CAPTURE)
        startActivityForResult(intent, REQUEST_CODE)
    }

    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)
        if ((requestCode == REQUEST_CODE) && (resultCode == RESULT_OK)) {
            val thumbnail: Bitmap? = data?.getParcelableExtra("data")
            capturedImageView.setImageBitmap(thumbnail)
        }
    }
}