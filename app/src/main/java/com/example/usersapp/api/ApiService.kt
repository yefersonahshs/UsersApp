package com.example.usersapp.api

import com.example.usersapp.models.Post
import com.example.usersapp.models.User
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Path

interface ApiService {

    @GET("/users")
    fun SearchAllUser(): Call<List<User>>

    @GET("/users/{user}/posts")
    fun getPostUser(@Path("user") user: String): Call <List<Post>>

}