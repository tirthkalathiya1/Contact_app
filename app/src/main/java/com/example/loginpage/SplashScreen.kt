package com.example.loginpage

import android.content.Intent
import android.content.SharedPreferences
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Handler
import android.os.Looper

class SplashScreen : AppCompatActivity() {

    companion object{
        lateinit var sp:SharedPreferences
        lateinit var edit:SharedPreferences.Editor
    }
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_splash_screen)

        sp=getSharedPreferences("name", MODE_PRIVATE)
        edit=sp.edit()

        Handler().postDelayed({
          if(sp.getBoolean("check",false)) {
              startActivity(Intent(this, Homepage::class.java))
              finish()
          }else{
              startActivity(Intent(this,Login::class.java))
              finish()
          }
        }, 2000)

    }
}