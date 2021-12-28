package com.example.usersapp

import retrofit2.Call
import retrofit2.http.GET

interface ApiService {

    @GET("/users")
    fun SearchAllUser():Call<List<User>>
}