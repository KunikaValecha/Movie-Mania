package com.example.moviedboffline.Data

import android.content.Context
import com.example.moviedboffline.model.RetrofitManager

class MovieDataSource(context: Context): BaseDataSource(context) {
    private val movieService = RetrofitManager.getMovieService()
    suspend fun getPopular(
        sort_by: String,
        apiKey : String
    ): RestClientResult<JSONtoObject>{
        return getResult { movieService.getPopularMovies(sort_by, apiKey) }
    }
}