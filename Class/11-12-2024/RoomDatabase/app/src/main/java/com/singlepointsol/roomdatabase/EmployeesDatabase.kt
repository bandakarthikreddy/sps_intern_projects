package com.singlepointsol.roomdatabase

import androidx.room.Database
import androidx.room.RoomDatabase

@Database(version = 1, entities = [Employee::class])
abstract class EmployeesDatabase() : RoomDatabase() {
    abstract fun getEmployeeDao(): EmployeeDao

}