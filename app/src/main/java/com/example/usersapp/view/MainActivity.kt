package com.example.usersapp.view

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.usersapp.R
import com.example.usersapp.api.ApiService
import com.example.usersapp.client.RetrofitClient
import com.example.usersapp.models.User
import com.example.usersapp.util.UserAdapter
import com.google.gson.GsonBuilder
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import kotlinx.android.synthetic.main.activity_main.*
import okhttp3.OkHttpClient


class MainActivity : AppCompatActivity() {
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


    private fun showData(users: List<User>) {
        recyclerView.apply {
            layoutManager = LinearLayoutManager(this@MainActivity)
            adapter =
                UserAdapter(
                    users
                )
        }
    }

    }

