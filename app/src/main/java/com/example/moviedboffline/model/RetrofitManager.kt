package com.example.moviedboffline.model

import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

object RetrofitManager {
    private var instance : Retrofit? = null
    private var movieService : GetMovieService? = null

    fun getRetrofit():Retrofit{
        if (instance == null){
            instance = Retrofit.Builder()
                .baseUrl("https://api.themoviedb.org")
                .addConverterFactory(GsonConverterFactory.create())
                .build()
        }
        return instance!!
    }

    fun getMovieService():GetMovieService {
        if (movieService == null) {
            movieService = getRetrofit().create(GetMovieService::class.java)
        }
        return movieService!!
    }
}