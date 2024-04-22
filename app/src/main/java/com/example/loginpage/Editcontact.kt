package com.example.loginpage

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.EditText
import android.widget.ImageView

class Editcontact :AppCompatActivity() {

//    lateinit var update:ImageView
//    lateinit var delete:ImageView
//    lateinit var editname:EditText
//    lateinit var editnumber:EditText
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_editcontact)

//        update=findViewById(R.id.update)
//        delete=findViewById(R.id.delete)
//        editname=findViewById(R.id.edit_name)
//        editnumber=findViewById(R.id.edit_number)
//
//        var ename=intent.getStringExtra("name")
//        var enumber=intent.getStringExtra("number")
//        editname.setText(ename)
//        editnumber.setText(enumber)
//
//        update.setOnClickListener {
//            var data=Mydatabase(this)
//            data.Update(ename.toString(),editname.text.toString().capitalize(),editnumber.text.toString())
//
//            var s=Intent(this@Editcontact,Homepage::class.java)
//            startActivity(s)
//
//        }
//        delete.setOnClickListener {
//
//            var deletedata=Mydatabase(this)
//            deletedata.delete(editname.text.toString().capitalize())
//            var s=Intent(this@Editcontact,Homepage::class.java)
//            startActivity(s)
//
//        }
    }
}