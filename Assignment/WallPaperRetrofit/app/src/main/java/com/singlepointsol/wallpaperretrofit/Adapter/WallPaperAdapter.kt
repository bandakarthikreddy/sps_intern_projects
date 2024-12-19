package com.singlepointsol.wallpaperretrofit.Adapter

import android.content.Intent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.singlepointsol.wallpaperretrofit.Activity.LargeActivity
import com.singlepointsol.wallpaperretrofit.DataClass.WallpaperItem
import com.singlepointsol.wallpaperretrofit.R

class WallPaperAdapter(
    private val wallpaperList: ArrayList<WallpaperItem> // Changed to ArrayList for mutability, like FlowersAdapter
) : RecyclerView.Adapter<WallPaperAdapter.ViewHolder>() {

    // ViewHolder class to hold item views
    class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val wallPaperImage: ImageView = itemView.findViewById(R.id.wallPaper_imageView)
        val userName: TextView = itemView.findViewById(R.id.wallPaperUser_textView)
        val viewsTextView: TextView = itemView.findViewById(R.id.wallPaperViews_textView)
        val likesTextView: TextView = itemView.findViewById(R.id.wallPaperLikes_textView)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.activity_wallpaper_card_view, parent, false)
        return ViewHolder(view)
    }

    override fun getItemCount(): Int = wallpaperList.size

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val wallpaper = wallpaperList[position]

        // Load the image using Glide
        Glide.with(holder.itemView.context)
            .load(wallpaper.previewURL)
            .placeholder(R.drawable.ic_launcher_background)
            .into(holder.wallPaperImage)

        // Set the text for the user, views, and likes
        holder.userName.text = "User: ${wallpaper.user}"
        holder.viewsTextView.text = "Views: ${wallpaper.views}"
        holder.likesTextView.text = "Likes: ${wallpaper.likes}"

        // Handle item click event to pass data to the LargeActivity
        holder.itemView.setOnClickListener {
            val intent = Intent(holder.itemView.context, LargeActivity::class.java)
            intent.putExtra("user", wallpaper.user)
            intent.putExtra("")
            holder.itemView.context.startActivity(intent)
        }
    }
}
