package com.example.usersapp.api

import com.example.usersapp.models.User
import retrofit2.Call
import retrofit2.http.GET

interface ApiService {

    @GET("/users")
    fun SearchAllUser():Call<List<User>>
}