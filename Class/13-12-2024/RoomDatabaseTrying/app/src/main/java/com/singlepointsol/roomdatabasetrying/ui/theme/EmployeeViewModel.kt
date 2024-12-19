package com.singlepointsol.roomdatabasetrying.ui.theme

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.singlepointsol.roomdatabasetrying.Employee
import com.singlepointsol.roomdatabasetrying.MainApplication
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class EmployeeViewModel : ViewModel() {

    private val employeeDao = MainApplication.employeeDatabase.employeeDao()
    val employeeList: LiveData<List<Employee>> = employeeDao.getAllEmployee()

    fun addEmployee(employee: Employee) {
        viewModelScope.launch(Dispatchers.IO) {
            employeeDao.addToEmployee(employee)
        }
    }

    fun deleteEmployee(id: Int) {
        viewModelScope.launch(Dispatchers.IO) {
            employeeDao.deleteEmployee(id)
        }
    }
}
