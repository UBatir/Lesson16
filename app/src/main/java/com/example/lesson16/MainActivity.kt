package com.example.lesson16

import android.R.attr.country
import android.os.Bundle
import android.view.View
import android.widget.PopupMenu
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
        setDat(0,1)
    }

    private fun setDat(size:Int, count:Int){
        for(i in size until count+size){
            val model=User()
            model.Title="Title ${i+1}"
            model.Description="Description ${i+1}"
            models.add(model)
        }
        adapter.setData(models)
    }


    private fun removeItem(position:Int,size:Int) {
            models.removeAt(position);
            adapter.notifyItemRemoved(position)
            adapter.notifyItemRangeChanged(position,size)
    }
    fun onItemClicked(size:Int,position:Int){
        setDat(size,position+1)
    }

    fun onOptionsButtonClick(view: View,size: Int,position: Int){
        val optionsMenu=PopupMenu(this,view)
        val menuInflater=optionsMenu.menuInflater
        menuInflater.inflate(R.menu.menu_item_options,optionsMenu.menu)
        optionsMenu.setOnMenuItemClickListener {
            when(it.itemId){
                R.id.itemAdd-> {
                    setDat(models.size,1)
                }
                R.id.itemDelete->{
                    removeItem(position,size)
                    }
                }
            return@setOnMenuItemClickListener true
            }
        optionsMenu.show()

    }
}
