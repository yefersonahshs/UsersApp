package com.example.usersapp.entitys

import androidx.room.Entity
import androidx.room.PrimaryKey


@Entity
data class UserEntity (

    @PrimaryKey(autoGenerate = true)
    var id:Int,
    var name :String,
    val email :String,
    val phone :String)