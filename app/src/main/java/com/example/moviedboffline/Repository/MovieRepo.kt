package com.example.moviedboffline.Repository

import com.example.moviedboffline.Data.JSONtoObject
import com.example.moviedboffline.Data.RestClientResult
import retrofit2.Response

interface MovieRepo {

    suspend fun getPopularMovies(
        sort_by : String,
        apiKey: String
    ): RestClientResult<JSONtoObject>
}