package com.singlepointsol.firebase

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class EmployeesAdapter(val employeesArrayList: ArrayList<Employees>) : RecyclerView.Adapter<EmployeesAdapter.ViewHolder>() {
    class ViewHolder(itemView: View): RecyclerView.ViewHolder(itemView) {
            val nameTextView : TextView = itemView.findViewById(R.id.name_textView)
            val emailTextView: TextView = itemView.findViewById(R.id.email_textView)
            val mobileTextView : TextView = itemView.findViewById(R.id.mobile_textView)
            val designationTextView : TextView  = itemView.findViewById(R.id.designation_textView)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.emp_row, parent, false)
        return ViewHolder(view)
    }

    override fun getItemCount(): Int {
        return employeesArrayList.size
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val employees = employeesArrayList[position]
        holder.nameTextView.text = employees.name
        holder.emailTextView.text = employees.email
        holder.mobileTextView.text = employees.mobile
        holder.designationTextView.text = employees.designation


    }

}
