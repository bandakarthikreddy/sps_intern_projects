package com.singlepointsol.roomdatabasetrying

import android.app.Application
import androidx.room.Room
import com.singlepointsol.roomdatabasetrying.ui.theme.db.EmployeeDatabase

class MainApplication : Application() {

    companion object {
        lateinit var employeeDatabase: EmployeeDatabase
    }

    override fun onCreate() {
        super.onCreate()
        employeeDatabase = Room.databaseBuilder(
            applicationContext,
            EmployeeDatabase::class.java,
            "employee_database"
        ).build()
    }
}
