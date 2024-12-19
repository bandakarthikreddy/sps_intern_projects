package com.singlepointsol.examassignment

import android.content.Intent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class CarsAdapter(private val carsArrayList: List<Cars>) : RecyclerView.Adapter<CarsAdapter.ViewHolder>() {

    // Corrected ViewHolder class
    class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val carImage: ImageView = itemView.findViewById(R.id.carList_imageView) // Adjust ID to match your layout
        val carName: TextView = itemView.findViewById(R.id.carList_textView) // Adjust ID to match your layout
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.cars_list, parent, false)
        return ViewHolder(view)
    }

    override fun getItemCount(): Int {
        return carsArrayList.size
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val car = carsArrayList[position]
        holder.carImage.setImageResource(car.carImage)
        holder.carName.text = car.carName

        holder.carImage.setOnClickListener(View.OnClickListener {
            val intent = Intent(it.context, CarDetailActivity::class.java)
            intent.putExtra("carImage", car.carImage)
            intent.putExtra("carName", car.carName)

            it.context.startActivity(intent)

            holder.carName.setOnClickListener(View.OnClickListener {
                val intent = Intent(it.context, CarDetailActivity::class.java)
                intent.putExtra("carImage", car.carImage)
                intent.putExtra("carName", car.carName)
                it.context.startActivity(intent)
            })
        })
    }
}
