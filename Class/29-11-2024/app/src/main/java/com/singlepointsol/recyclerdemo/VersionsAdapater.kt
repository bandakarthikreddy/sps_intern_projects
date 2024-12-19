package com.singlepointsol.recyclerdemo

import android.content.Intent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import androidx.recyclerview.widget.RecyclerView.ViewHolder

class VersionsAdapter(val versionsArray: Array<String>) : RecyclerView.Adapter<VersionsAdapter.ViewHolder>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): VersionsAdapter.ViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.list_item, parent,false)
        return ViewHolder(view)
    }

    class ViewHolder(itemView: View): RecyclerView.ViewHolder(itemView) {
        val versionName: TextView = itemView.findViewById(R.id.versions_name_text)
    }

    override fun onBindViewHolder(holder: VersionsAdapter.ViewHolder, position: Int) {
        holder.versionName.text = versionsArray[position]
        holder.versionName.setOnClickListener(View.OnClickListener {
            val intent = Intent(it.context,DetailsActivity::class.java)
            intent.putExtra("data", versionsArray[position])
            it.context.startActivity(intent)
        })

    }

    override fun getItemCount(): Int {
        return versionsArray.size
    }

}
