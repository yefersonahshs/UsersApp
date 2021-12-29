package com.example.usersapp.util

import android.content.ContentValues
import android.content.Context
import android.provider.AlarmClock
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Filter
import android.widget.TextView
import android.widget.Toast
import androidx.core.content.ContextCompat
import androidx.recyclerview.widget.RecyclerView
import com.example.usersapp.R
import com.example.usersapp.models.Post
import com.example.usersapp.models.User
import com.example.usersapp.view.DetailActivity
import kotlinx.android.synthetic.main.user_row.view.*


class PostAdapter(private val posts:List<Post>, private val mContext: Context,
): RecyclerView.Adapter<PostAdapter.ViewHolder>() {


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.post_row, parent, false)
        return ViewHolder(view)

    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val post = posts[position]
        holder.title.text = post.title
        holder.body.text = post.body

    }

    override fun getItemCount() = posts.size


    class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView){

        val title: TextView = itemView.firstName
        val body: TextView = itemView.email

    }

}


