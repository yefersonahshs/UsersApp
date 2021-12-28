package com.example.usersapp

import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class UserAdapter(private val users:List<User>):RecyclerView.Adapter<UserAdapter.ViewHolder>() {

    class ViewHolder(itemView:View){
        val firstName:TextView = itemView.firstName
        val email:TextView=itemView.email
        val phone:TextView=itemView.phone
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): UserAdapter.ViewHolder {
        TODO("Not yet implemented")
    }

    override fun onBindViewHolder(holder: UserAdapter.ViewHolder, position: Int) {
        TODO("Not yet implemented")
    }

    override fun getItemCount(): Int {
        TODO("Not yet implemented")
    }


}