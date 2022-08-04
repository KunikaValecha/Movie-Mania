package com.example.moviedboffline.model

import com.example.moviedboffline.Data.JSONtoObject
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Query
import javax.security.auth.callback.Callback

interface GetMovieService {

    @GET("/3/discover/movie")
    suspend fun getPopularMovies(
        @Query("sort_by")sort_by: String,
        @Query("api_key")apiKey: String
    ):Response<JSONtoObject>

}