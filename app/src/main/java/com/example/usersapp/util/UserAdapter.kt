package com.example.usersapp.util

import android.content.ContentValues
import android.content.Context
import android.content.Intent
import android.provider.AlarmClock.EXTRA_MESSAGE
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.AdapterView
import android.widget.Filter
import android.widget.TextView
import android.widget.Toast
import androidx.core.content.ContextCompat.startActivity
import androidx.recyclerview.widget.RecyclerView
import com.example.usersapp.R
import com.example.usersapp.models.User
import com.example.usersapp.view.DetailActivity
import kotlinx.android.synthetic.main.user_row.view.*
import java.lang.Character.toLowerCase



const val EXTRA_MESSAGE = "com.example.myfirstapp.MESSAGE"

class UserAdapter(private val users:List<User>,    private val mContext: Context,
):RecyclerView.Adapter<UserAdapter.ViewHolder>(){







    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
    val view=LayoutInflater.from(parent.context).inflate(R.layout.user_row,parent,false)
    return ViewHolder(view)

    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val user = users[position]
        holder.name.text=user.name
        holder.email.text=user.email
        holder.phone.text=user.phone

        holder.itemView.setOnClickListener {
            Log.d(ContentValues.TAG, "onClick: clicked on: " + users!![position])
            Toast.makeText(mContext, users!![position].id, Toast.LENGTH_SHORT).show()

            val intent = Intent(this, DetailActivity::class.java).apply {
                putExtra(EXTRA_MESSAGE, users!![position].id)
            }
            startActivity(intent)
        }

    }

    override fun getItemCount()=users.size


   inner class ViewHolder(itemView:View):RecyclerView.ViewHolder(itemView),
       View.OnClickListener {

       val name: TextView = itemView.firstName
       val email: TextView = itemView.email
       val phone: TextView = itemView.phone

       init {
           itemView.setOnClickListener(this)
       }

       override fun onClick(v: View?) {
           val position = adapterPosition
           if (position != RecyclerView.NO_POSITION) {
           }
       }
   }

    interface OnItemClickListener {
        fun onItemClick(position: Int)
    }

    fun getFilter(): Filter {

        return object : Filter() {
            override fun performFiltering(p0: CharSequence?): Filter.FilterResults {
                var listFilter=ArrayList<User>();
                if(p0==null||p0.isEmpty())
                {
                    listFilter.addAll(users)
                }else
                {
                    val filterPattern: String = p0.toString().toLowerCase().trim()
                    for (item in users) {
                        if (item.name.toLowerCase().contains(filterPattern)) {
                            listFilter.add(item)
                        }
                    }
                }
                val results = Filter.FilterResults()
                results.values = listFilter
                return  results;
            }

            override fun publishResults(p0: CharSequence?, p1: Filter.FilterResults?) {

               // listdataSearch
               // listdataSearch.addAll(p1?.values as Collection<User>)

                notifyDataSetChanged()
            }
        }


    }


}