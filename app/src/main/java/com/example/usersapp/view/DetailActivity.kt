package com.example.usersapp.view

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
import com.example.usersapp.util.UserAdapter
import kotlinx.android.synthetic.main.activity_main.*
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class DetailActivity : AppCompatActivity() {

    var userId = ""

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_detail)
        Log.d(TAG, "onCreate: started.")
        incomingIntent







        val call = RetrofitClient()

        val api = call.getRetrofit().create(ApiService::class.java)
        api.getPostUser(userId).enqueue(object : Callback<List<Post>> {
            override fun onResponse(call: Call<List<Post>>, response: Response<List<Post>>) {
                Log.d("exitoso", "onResponse: {${response.body()!![0].title}")

                showData( response.body()!!)


            }


            override fun onFailure(call: Call<List<Post>>, t: Throwable) {

                Log.d("falla", "onFailures")

            }


        })
    }



    private val incomingIntent: Unit
        private get() {
            Log.d(TAG, "getIncomingIntent: checking for incoming intents.")
            if (intent.hasExtra("id")) {
                Log.d(TAG, "getIncomingIntent: found intent extras.")
                val userId = intent.getIntExtra("id")


                setData(userId)
            }
        }

    private fun setData(userId: Int?){
        Log.d(TAG, "setImage: setting te image and name to widgets.")
        val title = findViewById<TextView>(R.id.title)
        title.text = title.toString()

        val body = findViewById<TextView>(R.id.body)
        body.text = body.toString()


    }

    companion object {
        private const val TAG = "DetailActivity"
    }

    private fun showData(posts: List<Post>) {


        //room.Postao().insert(posts)

        rv_user_list.apply {
            layoutManager = LinearLayoutManager(this)
            adapter =
                PostAdapter(
                    posts
                )
        }



    }
}



