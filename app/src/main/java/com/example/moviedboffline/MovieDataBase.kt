package com.example.moviedboffline

import androidx.room.Dao
import androidx.room.Database
import androidx.room.RoomDatabase
import com.example.moviedboffline.Data.JSONtoObject
import com.example.moviedboffline.Data.MovieDataSource
import com.example.moviedboffline.Data.Result

@Database(entities = [Result::class], version = 1)
abstract class MovieDataBase: RoomDatabase() {
    abstract fun movieDao(): MovieDao
}