package com.example.moviedboffline

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.example.moviedboffline.Data.JSONtoObject
import com.example.moviedboffline.Data.RestClientResult
import com.example.moviedboffline.Data.Result

@Dao
interface MovieDao {
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insert(movie: List<Result>)

    @Query("SELECT * from Result")
    fun showAllPopular(): LiveData<List<Result>>
}