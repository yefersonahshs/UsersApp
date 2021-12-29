package com.example.usersapp.`interface`

import androidx.room.*
import com.example.usersapp.models.User

@Dao
interface UserDao {

        @Delete
        fun delete(user: User)

        @Update
        fun update(user: User)

        @Insert(onConflict = OnConflictStrategy.IGNORE)
        fun insert(people: List<User>)

        @Query("SELECT * FROM UserEntity WHERE id = :id")
        fun findById(id: Int): User

        @Query("SELECT * from UserEntity")
        fun getAll(): List<User>
    }
