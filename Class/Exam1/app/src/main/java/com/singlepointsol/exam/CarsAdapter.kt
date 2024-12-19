package com.singlepointsol.exam

import android.content.Intent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.singlepointsol.exam1.ImageName
import com.singlepointsol.exam1.R

class CarsAdapter(val carsArrayList: ArrayList<Cars>) : RecyclerView.Adapter<CarsAdapter.ViewHolder>() {
    class ViewHolder(itemView: View): RecyclerView.ViewHolder(itemView) {
        val carsImage: ImageView = itemView.findViewById(R.id.image_view)
        val carsText: TextView = itemView.findViewById(R.id.text_view)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.card_layout, parent, false)
        return ViewHolder(view)
    }

    override fun getItemCount(): Int {
        return carsArrayList.size
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val version = carsArrayList[position]
        holder.carsImage.setImageResource(version.cImage)
        holder.carsText.text = version.cName

        holder.carsImage.setOnClickListener ({
            val intent = Intent(it.context, ImageName::class.java)
            intent.putExtra("itemClicked", carsArrayList) // Pass the car object
            it.context.startActivity(intent)
        })
    }

}
