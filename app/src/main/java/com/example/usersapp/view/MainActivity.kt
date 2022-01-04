package com.example.usersapp.view

import AppDatabase
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.room.Room

import com.example.usersapp.R
import com.example.usersapp.api.ApiService
import com.example.usersapp.client.RetrofitClient
import com.example.usersapp.models.User
import com.example.usersapp.util.RecyclerItemClickListener
import com.example.usersapp.util.UserAdapter
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import kotlinx.android.synthetic.main.activity_main.*


class MainActivity : AppCompatActivity(){

  //  val db = Room.databaseBuilder(
//        applicationContext,
 //       AppDatabase::class.java, "todo-list.db"
 //   ).build()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)


        val call = RetrofitClient()

        val api = call.getRetrofit().create(ApiService::class.java)
        api.SearchAllUser().enqueue(object : Callback<List<User>> {
            override fun onResponse(call: Call<List<User>>, response: Response<List<User>>) {
                Log.d("exitoso", "onResponse: {${response.body()!![0].email}")

                showData( response.body()!!)


            }


            override fun onFailure(call: Call<List<User>>, t: Throwable) {

                Log.d("falla", "onFailures")

            }


        })


    }

/*
    override fun onItemClick(position: Int) {
        Toast.makeText(this, "Item $position clicked", Toast.LENGTH_SHORT).show()
        val clickedItem = users[position]
        clickedItem.name = "Clicked"
        adapter.notifyItemChanged(position)
    }
*/
    private fun showData(users: List<User>) {


       // room.UserDao().insert(users)
//    val adapter= KotlinRecyclerAdapter(applicationContext,arrayList)

    rv_user_list.apply {
            layoutManager = LinearLayoutManager(this@MainActivity)
            adapter =
                UserAdapter(
                    users
                )
        }


            rv_user_list.addOnItemTouchListener(
                RecyclerItemClickListener(applicationContext,
                    RecyclerItemClickListener.OnItemClickListener { view, position ->
                        val intent= Intent(applicationContext,DetailActivity::class.java)
                        intent.putExtra("user", users[position].id)
                        startActivity(intent)
                    })
            )



    }

    }

