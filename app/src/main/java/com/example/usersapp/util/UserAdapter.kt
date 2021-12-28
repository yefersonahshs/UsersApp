package com.example.usersapp.util

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.usersapp.R
import com.example.usersapp.models.User
import kotlinx.android.synthetic.main.user_row.view.*

class UserAdapter(private val users:List<User>):RecyclerView.Adapter<UserAdapter.ViewHolder>() {



    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
    val view=LayoutInflater.from(parent.context).inflate(R.layout.user_row,parent,false)
    return ViewHolder(view)

    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val user = users[position]
        holder.firstName.text=user.firstName
        holder.email.text=user.email
        holder.phone.text=user.phone
    }

    override fun getItemCount()=users.size


    class ViewHolder(itemView:View):RecyclerView.ViewHolder(itemView){
        val firstName:TextView = itemView.firstName
        val email:TextView=itemView.email
        val phone:TextView=itemView.phone
    }


}