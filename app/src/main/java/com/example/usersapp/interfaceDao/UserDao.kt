package com.example.usersapp.interfaceDao

import androidx.room.*
import com.example.usersapp.entitys.UserEntity
import com.example.usersapp.models.User

@Dao
interface UserDao {

        @Delete
         fun delete(user: UserEntity)

        @Update
         fun update(user: UserEntity)

        @Insert(onConflict = OnConflictStrategy.IGNORE)
         fun insert(user: UserEntity)

        @Query("SELECT * FROM UserEntity WHERE id = :id")
         fun findById(id: Int): UserEntity

        @Query("SELECT * from UserEntity")
         fun getAll(): List<UserEntity>
    }
