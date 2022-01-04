package com.example.usersapp.interfaceDao

import androidx.room.*
import com.example.usersapp.entitys.PostEntity
import com.example.usersapp.models.Post


@Dao
interface PostDao {

    @Delete
     fun delete(post: PostEntity)

    @Update
     fun update(post: PostEntity)

    @Insert(onConflict = OnConflictStrategy.IGNORE)
     fun insert(post:List<PostEntity>)

    @Query("SELECT * FROM PostEntity WHERE id = :id")
     fun findById(id: Int): PostEntity

    @Query("SELECT * from PostEntity")
     fun getAll(): List<PostEntity>

}