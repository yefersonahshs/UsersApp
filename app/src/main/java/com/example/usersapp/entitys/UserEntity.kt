package com.example.usersapp.entitys

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey


@Entity
data class UserEntity (

    @PrimaryKey(autoGenerate = true)
    @ColumnInfo(name = "id")
    var id:Int,
    @ColumnInfo(name = "name")
    var name :String,
    @ColumnInfo(name = "email")
    val email :String,
    @ColumnInfo(name = "phone")
    val phone :String)