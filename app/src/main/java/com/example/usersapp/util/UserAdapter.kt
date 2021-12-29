package com.example.usersapp.util

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.AdapterView
import android.widget.Filter
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.usersapp.R
import com.example.usersapp.models.User
import kotlinx.android.synthetic.main.user_row.view.*
import java.lang.Character.toLowerCase

class UserAdapter(private val users:List<User>
                  private val listener: AdapterView.OnItemClickListener

):RecyclerView.Adapter<UserAdapter.ViewHolder>(){





    private val listdataSearch:List<User>


    init {
        listdataSearch= ArrayList()
        listdataSearch.addAll(users)
    }


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
    val view=LayoutInflater.from(parent.context).inflate(R.layout.user_row,parent,false)
    return ViewHolder(view)

    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val user = users[position]
        holder.name.text=user.name
        holder.email.text=user.email
        holder.phone.text=user.phone
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
               listener.onItemClick(position)
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