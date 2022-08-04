package com.example.moviedboffline.ui

import android.app.Application
import androidx.lifecycle.*
import androidx.room.Room
import androidx.room.RoomDatabase
import com.example.moviedboffline.Data.JSONtoObject
import com.example.moviedboffline.Data.RestClientResult
import com.example.moviedboffline.Data.Result
import com.example.moviedboffline.MovieDao
import com.example.moviedboffline.MovieDataBase
import com.example.moviedboffline.Repository.MovieRepo
import com.example.moviedboffline.Repository.MovieRepoImpl
import kotlinx.coroutines.launch

class MovieViewModel(mApp: Application): AndroidViewModel(mApp) {
    companion object{
        private const val apiKey = "4e5d3fc5345050126f509dae79bc3650"
    }
    val movieLiveData = MutableLiveData<RestClientResult<JSONtoObject>>()

    val getPopular: MovieRepo = MovieRepoImpl(mApp)

    fun getPopular(sort_by:String){
        viewModelScope.launch {
            val results = getPopular.getPopularMovies(sort_by, apiKey)
            movieLiveData.postValue(results)
        }
    }

    private val movieDataBase by lazy{
        Room.databaseBuilder(
            mApp.applicationContext,
            MovieDataBase::class.java,
            "database-name",
            ).build()
    }

    private val movieDao by lazy{
        movieDataBase.movieDao()
    }

    val oflMovieLiveData = movieDao.showAllPopular()

    fun insert(movie: List<Result>){
        viewModelScope.launch {
            movieDao.insert(movie)
        }
    }

}