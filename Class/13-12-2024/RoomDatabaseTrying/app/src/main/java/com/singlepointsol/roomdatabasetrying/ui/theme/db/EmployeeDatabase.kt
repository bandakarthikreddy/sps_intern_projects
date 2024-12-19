package com.singlepointsol.roomdatabasetrying.ui.theme.db

import androidx.room.Database
import androidx.room.RoomDatabase
import com.singlepointsol.roomdatabasetrying.Employee

@Database(entities = [Employee::class], version = 1)
abstract class EmployeeDatabase : RoomDatabase() {
    abstract fun employeeDao(): EmployeeDao
}
