package com.example.loginpage

import android.app.ActionBar.LayoutParams
import android.app.Dialog
import android.content.Intent
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.BaseAdapter
import android.widget.EditText
import android.widget.ImageView
import android.widget.PopupMenu
import android.widget.TextView

class Myadapter(
    var homepage: Homepage,
    var nameList: ArrayList<String>,
    var numberlist: ArrayList<String>
) : BaseAdapter() {
    override fun getCount(): Int {
        return nameList.size
    }

    override fun getItem(p0: Int): Any {
        return p0
    }

    override fun getItemId(p0: Int): Long {
        return p0.toLong()
    }

    override fun getView(p0: Int, p1: View?, p2: ViewGroup?): View {
        var name: TextView
        var number: TextView
        var first: TextView
        var popupmenu: ImageView
        var view = LayoutInflater.from(homepage).inflate(R.layout.xml, p2, false)
        name = view.findViewById(R.id.name)
        number = view.findViewById(R.id.number)
        first = view.findViewById(R.id.first)
        popupmenu = view.findViewById(R.id.popupmenu)
        name.setText(nameList[p0])
        number.setText(numberlist[p0])
        nameList.sort()

        var firstletter = nameList[p0].take(1).toUpperCase()
        first.text = firstletter

        popupmenu.setOnClickListener {

            var pmenu = PopupMenu(homepage, popupmenu)
            pmenu.menuInflater.inflate(R.menu.bcd, pmenu.menu)

            pmenu.setOnMenuItemClickListener { menu ->

                when (menu.itemId) {

                    R.id.edit -> {
                        var editname:EditText
                        var editnumber:EditText
                        var update:ImageView
                        var dialog=Dialog(homepage)
                        dialog.setContentView(R.layout.activity_editcontact)
                        dialog.window!!.setLayout(LayoutParams.MATCH_PARENT,LayoutParams.WRAP_CONTENT)
                        editname=dialog.findViewById(R.id.edit_name)
                        editnumber=dialog.findViewById(R.id.edit_number)
                        update=dialog.findViewById(R.id.update)
                        editname.setText(nameList[p0])
                        editnumber.setText(numberlist[p0])

                         dialog.show()

                       update.setOnClickListener {
                           var data=Mydatabase(homepage)
                           data.Update(name.text.toString(),editname.text.toString().capitalize(),editnumber.text.toString())
                           nameList.set(p0, editname.text.toString())
                           numberlist.set(p0,editnumber.text.toString())
                           notifyDataSetChanged()

                           dialog.dismiss()
                       }
                        Log.d("===","oncreat:$update")
                    }

                    R.id.delete -> {

                        var deletedata = Mydatabase(homepage)
                        deletedata.delete(name.text.toString())
                        nameList.removeAt(p0)
                        numberlist.removeAt(p0)
                        notifyDataSetChanged()
                    }
                }
                true
            }
            pmenu.show()
        }

        return view
    }

}
