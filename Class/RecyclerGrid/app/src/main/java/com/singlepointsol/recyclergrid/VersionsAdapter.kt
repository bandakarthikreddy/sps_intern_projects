package com.singlepointsol.recyclergrid

import android.content.Intent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import androidx.recyclerview.widget.RecyclerView

class VersionsImagesAdapter(private val versionsImageArray: Array<Int>) :
    RecyclerView.Adapter<VersionsImagesAdapter.ViewHolder>() {

    // ViewHolder class to bind the view
    class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val versionImageView: ImageView = itemView.findViewById(R.id.version_image)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.list_item, parent, false)
        return ViewHolder(view)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        // Set the image resource for the specific item in the array
        holder.versionImageView.setImageResource(versionsImageArray[position])
        holder.versionImageView.setOnClickListener(View.OnClickListener {
            val intent = Intent(it.context, ImageActivity::class.java)
            intent.putExtra("itemClicked", versionsImageArray[position])
            it.context.startActivity(intent)
        })
    }

    override fun getItemCount(): Int {
        // Return the size of the array
        return versionsImageArray.size
    }
}
