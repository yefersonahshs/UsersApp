package com.example.usersapp.Appdatabases

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import com.example.usersapp.interfaceDao.PostDao
import com.example.usersapp.interfaceDao.UserDao
import com.example.usersapp.entitys.PostEntity
import com.example.usersapp.entitys.UserEntity

@Database(entities = [UserEntity::class, PostEntity::class],
    version = 1
)
abstract class AppDatabase : RoomDatabase() {

    abstract fun PostDao(): PostDao
    abstract fun UserDao(): UserDao

    companion object {

        private var INSTANCE: AppDatabase? = null

        fun getAppDatabase(context: Context): AppDatabase? {
            if (INSTANCE == null) {
                INSTANCE = Room.databaseBuilder(context.applicationContext,
                    AppDatabase::class.java, "people")
                    .allowMainThreadQueries()
                    .fallbackToDestructiveMigration()
                    .build()
            }
            return INSTANCE
        }

        fun destroyInstance() {
            INSTANCE = null
        }
    }}

