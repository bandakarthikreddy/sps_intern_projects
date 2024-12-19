package com.singlepointsol.carsexam

import android.content.Intent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class CarsAdapter(private val carsArrayList: ArrayList<Cars>) : RecyclerView.Adapter<CarsAdapter.ViewHolder>() {

    // ViewHolder class
    class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val carsImage: ImageView = itemView.findViewById(R.id.cars_imageView)
        val carsName: TextView = itemView.findViewById(R.id.carnames_textView)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.activity_car_details, parent, false)
        return ViewHolder(view)
    }

    override fun getItemCount(): Int {
        return carsArrayList.size
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val car = carsArrayList[position]

        // Bind data to views
        holder.carsName.text = car.cName
        holder.carsImage.setImageResource(car.cImage)

        // Set click listener
        holder.carsImage.setOnClickListener {
            val intent = Intent(it.context, CarsDetailActivity::class.java).apply {
                putExtra("carImage", car.cImage)
                putExtra("carName", car.cName)
            }
            it.context.startActivity(intent)
        }
    }
}
