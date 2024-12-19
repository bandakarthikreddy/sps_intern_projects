package com.singlepointsol.roomdatabasetrying.ui.theme.db

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query
import com.singlepointsol.roomdatabasetrying.Employee

@Dao
interface EmployeeDao {
    @Query("SELECT * FROM Employee")
    fun getAllEmployee(): LiveData<List<Employee>>

    @Insert
    fun addToEmployee(employee: Employee)

    @Query("DELETE FROM Employee WHERE id = :id")
    fun deleteEmployee(id: Int)
}
