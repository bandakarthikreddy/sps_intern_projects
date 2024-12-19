package com.singlepointsol.BadmintonApplication

import android.provider.ContactsContract
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.singlepointsol.BadmintonApplication.Badminton
import com.singlepointsol.BadmintonApplication.R

class BadmintonAdapter(private val badmintonArrayList: ArrayList<Badminton>) : RecyclerView.Adapter<BadmintonAdapter.ViewHolder>() {
    class ViewHolder(itemView: View): RecyclerView.ViewHolder(itemView) {
            val name: TextView = itemView.findViewById(R.id.name_textView)
            val country: TextView = itemView.findViewById(R.id.country_textView)
            val year: TextView = itemView.findViewById(R.id.bornYear_textView)
            val handedness: TextView = itemView.findViewById(R.id.handedness_textView)
            val coachName: TextView = itemView.findViewById(R.id.coachName_textView)
            val matches: TextView = itemView.findViewById(R.id.matches_textView)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.badminton_row, parent, false)
        return ViewHolder(view)
    }

    override fun getItemCount(): Int {
        return badmintonArrayList.size
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val player = badmintonArrayList[position]

        holder.name.text = "Name: ${player.name}"
        holder.country.text = "Country: ${player.country}"
        holder.year.text = "Year of Birth: ${player.year}"
        holder.handedness.text = "Handedness: ${player.handedness}"
        holder.coachName.text = "Coach Name: ${player.coachName}"
        holder.matches.text = "Matches Played: ${player.matches}"

/*
        holder.name.setText(player.name)
        holder.country.setText(player.country)
        holder.year.setText(player.year)
        holder.handedness.setText(player.handedness)
        holder.coachName.setText(player.coachName)
        holder.matches.setText(player.matches)
  */
        }

    }
