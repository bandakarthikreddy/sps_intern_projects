package com.singlepointsol.exam

import android.content.Context
import android.content.Intent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.cardview.widget.CardView
import androidx.recyclerview.widget.RecyclerView

class CarsAdapter(val context: Context, private val carsArrayList: ArrayList<Cars>) :
    RecyclerView.Adapter<CarsAdapter.ViewHolder>() {
    // Adapter implementation

    class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val carsImage: ImageView = itemView.findViewById(R.id.cardImage_view)
        val carsText: TextView = itemView.findViewById(R.id.cardText_view)
        val cardView: CardView = itemView.findViewById(R.id.card_view)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.card_layout, parent, false)
        return ViewHolder(view)
    }

    override fun getItemCount(): Int {
        return carsArrayList.size
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val car = carsArrayList[position]
        holder.carsImage.setImageResource(car.cImage)
        holder.carsText.text = car.cName
/*
        // Set click listener for each card
        holder.itemView.setOnClickListener {
            val intent = Intent(context, ImageName::class.java)
            intent.putExtra("carName", car.cName)
            intent.putExtra("carImage", car.cImage)
            context.startActivity(intent)
        }

 */

        holder.cardView.setOnClickListener(View.OnClickListener {
            val intent =Intent(context, ImageName::class.java)
            intent.putExtra("carName", car.cName)
            intent.putExtra("carImage", car.cImage)
            context.startActivity(intent)
        })
    }
}
