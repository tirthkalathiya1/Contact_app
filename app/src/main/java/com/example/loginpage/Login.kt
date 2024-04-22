package com.example.loginpage

import android.content.Intent
import android.content.SharedPreferences
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import com.example.loginpage.SplashScreen.Companion.edit
import com.example.loginpage.SplashScreen.Companion.sp

class Login : AppCompatActivity() {

    lateinit var txt3:TextView
    lateinit var btn:Button
    lateinit var usernamelogin:EditText
    lateinit var Passwordlogin:EditText


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.login)

//        sp=getSharedPreferences("name", MODE_PRIVATE)
//        edit=sp.edit()

        txt3=findViewById(R.id.txt3)
        btn=findViewById(R.id.btn)
        usernamelogin = findViewById(R.id.uname_login)
        Passwordlogin = findViewById(R.id.password_login)

        var logindata=Mydatabase(this)

        btn.setOnClickListener {

            var selectdata= logindata.selectdata(usernamelogin.text.toString(),Passwordlogin.text.toString())

            var id = 0;
            while (selectdata.moveToNext()){
               id=selectdata.getInt(0)
                edit.putInt("id",id)
                edit.apply()

                edit.putBoolean("check",true)
                edit.apply()

                var s=Intent(this@Login,Homepage::class.java)
                startActivity(s)
                finish()
            }
            Log.d("===","oncreate: $id")
        }

        txt3.setOnClickListener {
            var intent=Intent(this@Login,Signup::class.java)
            startActivity(intent)
        }
    }
}