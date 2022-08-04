package com.example.moviedboffline.ui


import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import com.example.moviedboffline.Data.Result
import com.example.moviedboffline.R

class MovieAdapter: ListAdapter<Result, MovieViewHolder>(ITEM_CALLBACK) {
    companion object{
        val ITEM_CALLBACK = object : DiffUtil.ItemCallback<Result>(){
            override fun areItemsTheSame(oldItem: Result, newItem: Result): Boolean {
                return oldItem.id== newItem.id
            }

            override fun areContentsTheSame(oldItem: Result, newItem: Result): Boolean {
               return oldItem == newItem
            }

        }
    }
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MovieViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.cell, parent, false)
        return MovieViewHolder(view)
    }

    override fun onBindViewHolder(holder: MovieViewHolder, position: Int) {
        getItem(position)?.let {
            holder.onBind(it)
        }
    }
}