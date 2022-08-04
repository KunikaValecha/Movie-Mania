package com.example.moviedboffline.ui

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.moviedboffline.Data.RestClientResult
import com.example.moviedboffline.Data.Result
import com.example.moviedboffline.R

class MainActivity : AppCompatActivity() {
    private val viewModel by lazy{
        ViewModelProvider(this).get(MovieViewModel::class.java)
    }
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        viewModel.getPopular("popularity.desc")

        viewModel.movieLiveData.observe(this){
            when(it.status){
                RestClientResult.Status.LOADING ->{

                }
                RestClientResult.Status.SUCCESS ->{
                    viewModel.insert(movie = it?.data?.results.orEmpty())
                }
                RestClientResult.Status.ERROR->{
                    Toast.makeText(this, it.errorMessage, Toast.LENGTH_SHORT).show()
                }
            }
        }

        val rV = findViewById<RecyclerView>(R.id.RVMovie)
        rV.layoutManager = GridLayoutManager(this, 2)
        val adapter = MovieAdapter()
        rV.adapter = adapter

        viewModel.oflMovieLiveData.observe(this){
            adapter.submitList(it)
        }
    }
}