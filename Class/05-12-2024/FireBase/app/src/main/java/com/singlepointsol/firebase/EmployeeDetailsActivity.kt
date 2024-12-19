package com.singlepointsol.firebase

import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.google.firebase.database.DataSnapshot
import com.google.firebase.database.DatabaseError
import com.google.firebase.database.DatabaseReference
import com.google.firebase.database.FirebaseDatabase
import com.google.firebase.database.ValueEventListener

class EmployeeDetailsActivity : AppCompatActivity(), ValueEventListener {
    // Declaring Globally
    private lateinit var recyclerView: RecyclerView
    // Array
    private lateinit var employeesArrayList: ArrayList<Employees>
    // Database Reference
    private lateinit var databaseReference: DatabaseReference
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_employee_details)
        // Loading Views into Activity
        recyclerView = findViewById(R.id.recycler_view)
        // Layout Inflater
        recyclerView.layoutManager = LinearLayoutManager(this)
        // Array of Data
        employeesArrayList = ArrayList()
        // To receive data from Realtime database to the App the clicking the load button
        getEmployees()
        // Adapter of Array for data
        // If this is placed here the adapter is not receiving data from the Realtime Database
         //recyclerView.adapter = EmployeesAdapter(employeesArrayList)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
    }

    private fun getEmployees() {
        databaseReference = FirebaseDatabase.getInstance().getReference("Employees")
        databaseReference.addValueEventListener(this)
    }

    override fun onDataChange(snapshot: DataSnapshot) {
        if (snapshot.exists()) {
            for (userSnapshot in snapshot.children) {
                val emp = userSnapshot.getValue(Employees::class.java)
                if (emp != null) {
                    employeesArrayList.add(emp)
                }
                recyclerView.adapter = EmployeesAdapter(employeesArrayList)
            }
        }
    }

    override fun onCancelled(error: DatabaseError) {
        TODO("Not yet implemented")
    }
}