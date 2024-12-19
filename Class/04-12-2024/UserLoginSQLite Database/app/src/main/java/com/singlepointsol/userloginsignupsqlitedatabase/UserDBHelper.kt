package com.singlepointsol.userloginsignupsqlitedatabase

import android.content.ContentValues
import android.content.Context
import android.database.sqlite.SQLiteDatabase
import android.database.sqlite.SQLiteOpenHelper
import org.w3c.dom.Text

class UserDBHelper(context: Context): SQLiteOpenHelper(context, DATABASE_NAME, null, DATABASE_VERSION) {
    companion object {
        const val DATABASE_NAME = "user_database.db"
        const val DATABASE_VERSION = 1
        const val DATABASE_TABLE = "user_table"
        const val KEY_ID = "_ID"
        const val KEY_NAME = "Name"
        const val KEY_EMAIL = "Email"
        const val KEY_PASSWORD = "PASSWORD"
        const val KEY_MOBILE = "Mobile"

    }

    override fun onCreate(db: SQLiteDatabase?) {
        val createTable = "create table $DATABASE_TABLE ($KEY_ID INTEGER PRIMARY KEY AUTOINCREMENT, $KEY_NAME TEXT, $KEY_EMAIL Text, $KEY_PASSWORD TEXT, $KEY_MOBILE TEXT)"
        db?.execSQL(createTable)
    }

    override fun onUpgrade(db: SQLiteDatabase?, oldVersion: Int, newVersion: Int) {
        db!!.execSQL("drop table if exists $DATABASE_TABLE")
        onCreate(db)
    }

    /*
    fun addUser(user: User): Long {
        val db = this.writableDatabase
        val contentValues = ContentValues()
        contentValues.put(KEY_NAME, user.name)
        contentValues.put(KEY_EMAIL, user.email)
        contentValues.put(KEY_PASSWORD, user.password)
        contentValues.put(KEY_MOBILE, user.mobile)
        return db.insert(DATABASE_TABLE, null, contentValues)
    }
     */

    fun insertUser(name: String, email: String, password: String, mobile: String): Long {
        val db = this.writableDatabase
            val contentValues = ContentValues().apply {
                put(KEY_NAME, name)
                put(KEY_EMAIL, email)
                put(KEY_PASSWORD, password)
                put(KEY_MOBILE, mobile)
        }
            return db.insert(DATABASE_TABLE, null, contentValues)
    }
    fun isUserValid(email: String, password: String) : Boolean {
        val db = this.readableDatabase
        val query = "SELECT * FROM $DATABASE_TABLE WHERE $KEY_EMAIL =? AND $KEY_PASSWORD =?"
        val cursor = db.rawQuery(query, arrayOf(email, password))
        val isValid = cursor.count > 0
        cursor.close()
        return isValid

    }
}