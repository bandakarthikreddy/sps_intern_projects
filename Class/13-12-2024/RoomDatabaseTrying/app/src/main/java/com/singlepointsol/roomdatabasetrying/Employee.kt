package com.singlepointsol.roomdatabasetrying

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity
data class Employee(
    @PrimaryKey(autoGenerate = true)
    val id: Int = 0,
    val name: String,
    val mobile: String,
    val email: String,
    val designation: String,
    val addedAt: String
)
