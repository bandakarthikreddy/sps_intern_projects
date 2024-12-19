package com.singlepointsol.wallpaperretrofit.Activity


import android.content.Intent
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.ImageView
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import com.bumptech.glide.Glide
import com.singlepointsol.wallpaperretrofit.DataClass.WallpaperItem
import com.singlepointsol.wallpaperretrofit.R

class LargeActivity : AppCompatActivity(), View.OnClickListener {

    private lateinit var homeButton: Button
    private lateinit var imageView: ImageView
    private lateinit var userTextView: TextView
    private lateinit var viewsTextView: TextView
    private lateinit var downloadsTextView: TextView
    private lateinit var collectionsTextView: TextView
    private lateinit var likesTextView: TextView
    private lateinit var commentsTextView: TextView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_large)

        // Initialize views
        homeButton = findViewById(R.id.home_button)
        imageView = findViewById(R.id.largeWallPaperImage_imageView)
        userTextView = findViewById(R.id.largeWallPaperUser_textView)
        viewsTextView = findViewById(R.id.largeWallPaperViews_textView)
        downloadsTextView = findViewById(R.id.largeWallPaperDownloads_textView)
        collectionsTextView = findViewById(R.id.largeWallPaperCollections_textView)
        likesTextView = findViewById(R.id.largeWallPaperLikes_textView)
        commentsTextView = findViewById(R.id.largeWallPaperComments_textView)

        homeButton.setOnClickListener(this)

        // Fetch wallpaper details from intent
        val wallpaper: WallpaperItem? = intent.getParcelableExtra<WallpaperItem>("WALLPAPER_DETAILS")
        // Correct method

        if (wallpaper != null) {
            displayWallpaperDetails(wallpaper)
        } else {
            // Handle null case
            userTextView.text = "No Data Found"
        }
    }

    private fun displayWallpaperDetails(wallpaper: WallpaperItem) {
        // Load the image using Glide
        Glide.with(this)
            .load(wallpaper.webFormatURL)
            .into(imageView)



        // Populate text views
        userTextView.text = "User: ${wallpaper.user}"
        viewsTextView.text = "Views: ${wallpaper.views}"
        downloadsTextView.text = "Downloads: ${wallpaper.downloads}"
        collectionsTextView.text = "Collections: ${wallpaper.collections}"
        likesTextView.text = "Likes: ${wallpaper.likes}"
        commentsTextView.text = "Comments: ${wallpaper.comments}"
    }

    override fun onClick(v: View?) {
        // Navigate back to MainActivity when home button is clicked
        startActivity(Intent(this@LargeActivity, MainActivity::class.java))
    }
}
