package com.example.lesson16

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView

class ListAdapter(private val activity: MainActivity):RecyclerView.Adapter<ListViewHolder>() {

    private var mode:List<User> = listOf()

    fun setData(data:List<User>){
        mode=data
        notifyDataSetChanged()
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ListViewHolder {
        val itemView=LayoutInflater.from(parent.context).inflate(R.layout.item,parent,false)
        return ListViewHolder(itemView)
    }

    override fun getItemCount(): Int {
        return mode.size
    }

    override fun onBindViewHolder(holder: ListViewHolder, position: Int) {
        holder.populateModel(mode[position],itemCount,position,activity)
    }
}