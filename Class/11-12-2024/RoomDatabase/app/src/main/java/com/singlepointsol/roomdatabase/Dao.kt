package com.singlepointsol.roomdatabase

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.Query
import androidx.room.Update

@Dao
interface EmployeeDao {
    @Insert
    fun addEmployee(employee: Employee)

    @Query("select * from employees_table")
    fun getAllEmployees() : List<Employee>

    @Update
    fun updateEmployee(employee: Employee)

    @Delete
    fun deleteEmployee(employee: Employee)
}
