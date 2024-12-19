package com.singlepointsol.sqlitedatabase

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class EmployeeAdapter(val employeesArrayList: ArrayList<Employee>) : RecyclerView.Adapter<EmployeeAdapter.ViewHolder>() {
    class ViewHolder(itemView: View):RecyclerView.ViewHolder(itemView) {
        val nameTextView: TextView = itemView.findViewById(R.id.name_textView)
        val emailTextView: TextView = itemView.findViewById(R.id.email_textView)
        val mobileTextView: TextView = itemView.findViewById(R.id.mobile_textView)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.emp_row, parent, false)
        return ViewHolder(view)
    }

    override fun getItemCount(): Int {
        return employeesArrayList.size
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
            val employee = employeesArrayList[position]
            holder.nameTextView.text = employee.name
            holder.emailTextView.text = employee.email
            holder.mobileTextView.text = employee.mobile

    }

}
