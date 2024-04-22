package com.example.loginpage

import android.content.Context
import android.database.Cursor
import android.database.sqlite.SQLiteDatabase
import android.database.sqlite.SQLiteOpenHelper
import android.util.Log

class Mydatabase(context: Context):SQLiteOpenHelper(context,"data.db",null,1) {
    override fun onCreate(db: SQLiteDatabase){

        var table="CREATE TABLE mytable(id INTEGER PRIMARY KEY autoincrement,name text UNIQUE,email text UNIQUE, Password text ,Confirm text )"
        db.execSQL(table)

        var Contact_table="CREATE TABLE contact_table(id INTEGER,Name text UNIQUE,Number text UNIQUE)"
        db.execSQL(Contact_table)

    }
    override fun onUpgrade(db: SQLiteDatabase?, p1: Int, p2: Int) {
    }
    fun insertdata(name:String,email:String,Password:String,Confirm:String) {

        var insert = "INSERT INTO mytable(name,email,Password,Confirm)Values('$name','$email','$Password','$Confirm')"
        try {
            writableDatabase.execSQL(insert)
        } catch (e: Exception) {

            Log.e("===","insertdata: $e")
        }
    }

    fun selectdata(name:String,Password:String): Cursor {

        var select="SELECT * FROM mytable WHERE name ='$name' AND Password='$Password'"

        var cursor: Cursor = readableDatabase.rawQuery(select,null)

        return cursor
    }

    fun insertdata1(id:Int,name: String, number: String):Boolean {

        var insert1 = "INSERT INTO contact_table(id,name,number)Values('$id','$name','$number')"
        try {
            writableDatabase.execSQL(insert1)
           return true
        } catch (e: Exception) {

            Log.e("===","insertdata: $e")
            return false
        }
    }

    fun contactselect(id:Int): Cursor {

        var select="SELECT * FROM contact_table WHERE id= '$id'"
       return readableDatabase.rawQuery(select,null)

    }

    fun Update(oldn:String,name: String, number: String) {

        var edit="update contact_table set name='$name',number='$number' where name='$oldn'"
        writableDatabase.execSQL(edit)
    }

    fun delete(name: String) {

        var delete="delete from contact_table where name='$name'"
        writableDatabase.execSQL(delete)
    }

}