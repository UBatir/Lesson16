package com.example.lesson16

import android.view.View
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import kotlinx.android.synthetic.main.item.view.*
import java.text.FieldPosition

class ListViewHolder(itemView: View):RecyclerView.ViewHolder(itemView) {
    private val tvTitle: TextView =itemView.tvTitle
    private val tvDescription:TextView=itemView.tvDescription

    fun populateModel(user: User,size:Int,position:Int, activity: MainActivity){
        tvTitle.text=user.Title
        tvDescription.text=user.Description
        itemView.setOnClickListener() {
            activity.onItemClicked(size,position)
        }
        itemView.btnOptions.setOnClickListener{
            activity.onOptionsButtonClick(itemView.btnOptions,size,position)
        }
    }
}