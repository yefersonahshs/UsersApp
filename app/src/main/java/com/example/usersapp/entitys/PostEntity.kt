package com.example.usersapp.entitys

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity
data class PostEntity (
            @PrimaryKey(autoGenerate = true)
            val id: Int,
            val userId: Int,
            val title: String,
            val body: String
    )
