package com.example.usersapp.client

import com.google.gson.GsonBuilder
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class RetrofitClient {

    fun getRetrofit():Retrofit{

        val logging = HttpLoggingInterceptor() //nos ayudara a saber la informacion que trae la llamada
        logging.level = HttpLoggingInterceptor.Level.BODY
        val client = OkHttpClient.Builder()
            .addInterceptor(logging)
            .build()
        val gson = GsonBuilder()
            .setLenient()
            .create()

        return Retrofit.Builder()
            .baseUrl("https://jsonplaceholder.typicode.com")//url base de la que consumiremos el servicio
            .addConverterFactory(GsonConverterFactory.create(gson))
            .client(client)
            .build()
                }

        }
