package com.example.usersapp.entitys

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity
data class PostEntity (
            @PrimaryKey(autoGenerate = true)
            @ColumnInfo(name = "id")
            val id: Int,
            @ColumnInfo(name = "userId")
            val userId: Int,
            @ColumnInfo(name = "title")
            val title: String,
            @ColumnInfo(name = "body")
            val body: String
    )
