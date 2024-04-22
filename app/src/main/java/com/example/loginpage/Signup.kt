package com.example.loginpage

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText

class Signup : AppCompatActivity() {

    lateinit var name:EditText
    lateinit var email:EditText
    lateinit var pass:EditText
    lateinit var confirm:EditText
    lateinit var signup:Button


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_signup)

        name=findViewById(R.id.Name_signup)
        email=findViewById(R.id.email_signup)
        pass=findViewById(R.id.pass_signup)
        confirm=findViewById(R.id.confirm_signup)
        signup=findViewById(R.id.btn)

        var data= Mydatabase(this)

           signup.setOnClickListener{

               data.insertdata(name.text.toString(),email.text.toString(),pass.text.toString(),confirm.text.toString())
           }

    }
}