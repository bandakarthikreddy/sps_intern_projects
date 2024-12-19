package com.singlepointsol.customrecyclerviewdataclass

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class VersionsAdapter(val versionsArrayList: ArrayList<Versions>) : RecyclerView.Adapter<VersionsAdapter.ViewHolder>() {
    class ViewHolder(itemView: View): RecyclerView.ViewHolder(itemView) {
        val versionImage: ImageView = itemView.findViewById(R.id.version_imageView)
        val versionText: TextView = itemView.findViewById(R.id.version_textView)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
       val view = LayoutInflater.from(parent.context).inflate(R.layout.list_item, parent, false)
        return ViewHolder(view)
    }

    override fun getItemCount(): Int {
        return versionsArrayList.size
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val version = versionsArrayList[position]
        holder.versionImage.setImageResource(version.vImage)
        holder.versionText.text = version.vName
    }

}
