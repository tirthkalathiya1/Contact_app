package com.example.loginpage

import android.app.ActionBar.LayoutParams
import android.app.Dialog
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.EditText
import android.widget.ImageView
import android.widget.ListView
import android.widget.SearchView
import com.example.loginpage.SplashScreen.Companion.sp

class Homepage : AppCompatActivity() {

    lateinit var show: ListView
    lateinit var contactadd: ImageView
    var namelist = ArrayList<String>()
    var numberlist = ArrayList<String>()
    lateinit var logout:ImageView
    lateinit var serch:SearchView
    var list= ArrayList<Dataclass>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_homepage)

        show = findViewById(R.id.show)
        contactadd = findViewById(R.id.contactadd)
        logout=findViewById(R.id.logout)
        serch=findViewById(R.id.serch)

        serch.setOnQueryTextListener(object :SearchView.OnQueryTextListener{
            override fun onQueryTextSubmit(query: String?): Boolean {

                return true
            }
            override fun onQueryTextChange(p0: String?): Boolean {

                var serchh=ArrayList<String>()
                var serchnum=ArrayList<String>()
                serchh.clear()

                for(i in 0 until namelist.size){
                    if(namelist.get(i).lowercase().contains((p0.toString().lowercase())))
                    {
//                        var data=Dataclass(namelist.get(i),numberlist.get(i))
//                        list.add(data)
                      serchh.add(namelist.get(i))
                      serchnum.add(numberlist.get(i))
                    }
                }
                var adapter = Myadapter(this@Homepage, serchh,serchnum)
                show.adapter = adapter
                Log.d("====","oncreat:$p0")

                return true
            }

        })

        logout.setOnClickListener {

            startActivity(Intent(this,Login::class.java))
        }

        var id = sp.getInt("id", 0)

        var data = Mydatabase(this)
        var cursor = data.contactselect(id)

        while (cursor.moveToNext()) {
            namelist.add(cursor.getString(1))
            numberlist.add(cursor.getString(2))
        }

        var adapter = Myadapter(this, namelist, numberlist)
        show.adapter = adapter
//        show.setOnItemClickListener { adapterView, view, i, l ->
//
//            var s = Intent(this@Homepage, Editcontact::class.java).putExtra("name", namelist[i]).putExtra("number", numberlist[i])
//            startActivity(s)
//        }
        contactadd.setOnClickListener {

            var namee: EditText
            var number: EditText
            var rightt: ImageView
            var close:ImageView

            var dialog = Dialog(this)
            dialog.setContentView(R.layout.activity_contact)
            dialog.window!!.setLayout(LayoutParams.MATCH_PARENT, LayoutParams.WRAP_CONTENT)
            dialog.setCancelable(false)

            namee = dialog.findViewById(R.id.cotact_name)
            number = dialog.findViewById(R.id.contact_number)
            rightt = dialog.findViewById(R.id.rightt)
            close = dialog.findViewById(R.id.close)
            dialog.show()

           var dataa=Mydatabase(this)

            rightt.setOnClickListener {
                var id = sp.getInt("id", 0)
                var check = dataa.insertdata1(id, namee.text.toString().capitalize(), number.text.toString())

                var cursor = data.contactselect(id)
                namelist.clear()
                numberlist.clear()
                while (cursor.moveToNext()) {

                    var data=Dataclass(cursor.getString(1),cursor.getString(2))
                    list.add(data)
//                    namelist.add(cursor.getString(1))
//                    numberlist.add(cursor.getString(2))
                }
                dialog.dismiss()
                var adapter = Myadapter(this, namelist, numberlist)
                show.adapter = adapter

            }
            close.setOnClickListener {
                dialog.dismiss()

            }
        }
    }
}