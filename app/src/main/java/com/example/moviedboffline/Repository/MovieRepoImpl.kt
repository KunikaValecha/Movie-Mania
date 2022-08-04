package com.example.moviedboffline.Repository

import android.content.Context
import com.example.moviedboffline.Data.JSONtoObject
import com.example.moviedboffline.Data.MovieDataSource
import com.example.moviedboffline.Data.RestClientResult
import retrofit2.Response

class MovieRepoImpl(context: Context): MovieRepo {
    val dataSource= MovieDataSource(context)
    override suspend fun getPopularMovies(
        sort_by: String,
        apiKey: String): RestClientResult<JSONtoObject> {
        return dataSource.getPopular(sort_by, apiKey)
    }
}