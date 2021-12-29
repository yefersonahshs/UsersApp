package com.example.usersapp.view

import android.content.ContentValues.TAG
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.ImageView
import android.widget.TextView
import com.example.usersapp.R
import com.example.usersapp.api.ApiService
import com.example.usersapp.client.RetrofitClient
import com.example.usersapp.models.User
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class DetailActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_detail)
        Log.d(TAG, "onCreate: started.")
        incomingIntent




        val userId = intent.getIntExtra("id")


        val call: Call<Employe> = GetEmploye.getEmploye("session_id=$mSession_id", 2)

        val call = RetrofitClient()

        val api = call.getRetrofit().create(ApiService::class.java)
        api.getPostUser()
        api.getPostUser().enqueue(object : Callback<List<User>> {
            override fun onResponse(call: Call<List<User>>, response: Response<List<User>>) {
                Log.d("exitoso", "onResponse: {${response.body()!![0].email}")

                showData( response.body()!!)


            }


            override fun onFailure(call: Call<List<User>>, t: Throwable) {

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
        val name = findViewById<TextView>(R.id.title_id)
        name.text = title

    }

    companion object {
        private const val TAG = "DetailActivity"
    }
}



}