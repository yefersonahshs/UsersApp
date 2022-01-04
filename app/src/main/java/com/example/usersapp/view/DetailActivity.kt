package com.example.usersapp.view

import android.content.ContentValues.TAG
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.TextView
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.usersapp.R
import com.example.usersapp.api.ApiService
import com.example.usersapp.client.RetrofitClient
import com.example.usersapp.models.Post
import com.example.usersapp.models.User
import com.example.usersapp.util.PostAdapter
import kotlinx.android.synthetic.main.activity_detail.*
import kotlinx.android.synthetic.main.activity_main.*
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class DetailActivity : AppCompatActivity() {


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_detail)
        Log.d(TAG, "onCreate: started.")
        System.out.println("user id 2")


        var userId = intent.getStringExtra("user")
        System.out.println(userId)

        val call = RetrofitClient()

        val api = call.getRetrofit().create(ApiService::class.java)
        api.getPostUser((userId).toString()).enqueue(object : Callback<List<Post>> {
            override fun onResponse(call: Call<List<Post>>, response: Response<List<Post>>) {
                Log.d("exitoso", "onResponse: {${response.body()!![0].title}")

                showData( response.body()!!)


            }



            override fun onFailure(call: Call<List<Post>>, t: Throwable) {
                TODO("Not yet implemented")
            }


        })



    }



    private fun setData(userId: String?){
        Log.d(TAG, "setImage: setting te image and name to widgets.")
        val title = findViewById<TextView>(R.id.title)
        System.out.println("rrrrrrrr$userId" )

    }

    companion object {
        private const val TAG = "DetailActivity"
    }

    private fun showData(posts: List<Post>) {


        //room.Postao().insert(posts)

        rv_post_list.apply {
            layoutManager = LinearLayoutManager(this@DetailActivity)
            adapter =
                PostAdapter(
                    posts
                )
        }



    }
}



