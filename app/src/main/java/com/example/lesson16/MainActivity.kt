package com.example.lesson16

import android.R.attr.country
import android.os.Bundle
import android.view.View
import android.widget.PopupMenu
import android.widget.Toast
import androidx.appcompat.app.AlertDialog
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import kotlinx.android.synthetic.main.activity_main.*


class MainActivity : AppCompatActivity() {

    private val adapter:ListAdapter= ListAdapter(this)
    private val models:MutableList<User> = mutableListOf()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        recycleView.adapter=adapter
        recycleView.layoutManager=LinearLayoutManager(this,LinearLayoutManager.VERTICAL,false)
        setDat(1)
    }

    private fun setDat(count:Int){
        for(i in 0 until count){
            val model=User()
            model.Title="Title ${i+1}"
            model.Description="Description ${i+1}"
            models.add(model)
        }
        adapter.setData(models)
    }

    fun onOptionsButtonClick(view: View,position: Int){
        val optionsMenu=PopupMenu(this,view)
        val menuInflater=optionsMenu.menuInflater
        menuInflater.inflate(R.menu.menu_item_options,optionsMenu.menu)
        optionsMenu.setOnMenuItemClickListener {
            when(it.itemId){
                R.id.itemAdd-> {
                    val dialog=AlertDialog.Builder(this)
                    dialog.setTitle("Are you going to add Item?")
                    dialog.setMessage("Ozin bil!")
                    dialog.setPositiveButton("Yes"){_,_->
                        adapter.addItem(position+1)
                        Toast.makeText(this,"Yes",Toast.LENGTH_SHORT).show()
                    }
                    dialog.setNegativeButton("No"){_,_->
                        Toast.makeText(this,"No",Toast.LENGTH_SHORT).show()
                    }
                    dialog.show()
                }
                R.id.itemDelete-> {
                    val dialog = AlertDialog.Builder(this)
                    dialog.setTitle("Are you going to delete Item?")
                    dialog.setMessage("If you delete it you will not be able to restore Item")
                    dialog.setPositiveButton("Yes") { _, _ ->
                        adapter.removeItem(position)
                        Toast.makeText(this, "Yes", Toast.LENGTH_SHORT).show()
                    }
                    dialog.setNegativeButton("No") { _, _ ->
                        Toast.makeText(this, "No", Toast.LENGTH_SHORT).show()
                    }
                    dialog.show()
                    }
                }
            return@setOnMenuItemClickListener true
            }
        optionsMenu.show()

    }
}
