package com.example.usersapp.`interface`

import androidx.room.*
import com.example.usersapp.models.Post
import com.example.usersapp.models.User

@Dao

interface PostDao {

    @Delete
    fun delete(post: Post)

    @Update
    fun update(post: Post)

    @Insert(onConflict = OnConflictStrategy.IGNORE)
    fun insert(post:List<Post>)

    @Query("SELECT * FROM PostEntity WHERE id = :id")
    fun findById(id: Int): com.example.usersapp.models.Post

    @Query("SELECT * from PostEntity")
    fun getAll(): List<com.example.usersapp.models.Post>

}