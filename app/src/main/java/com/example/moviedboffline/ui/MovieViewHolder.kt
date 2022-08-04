package com.example.moviedboffline.ui

import android.view.View
import android.widget.ImageView
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.bumptech.glide.load.resource.bitmap.CenterCrop
import com.bumptech.glide.load.resource.bitmap.RoundedCorners
import com.bumptech.glide.request.RequestOptions
import com.example.moviedboffline.Data.Result
import com.example.moviedboffline.R

class MovieViewHolder(eachView: View) : RecyclerView.ViewHolder(eachView) {
    fun onBind(movie: Result) {
        val iView = itemView.findViewById<ImageView>(R.id.cell)
        val path = "https://image.tmdb.org/t/p/w500" + movie.poster_path
        Glide.with(itemView)
            .load(path)
            .apply(
                RequestOptions().transform(
                    CenterCrop(),
                    RoundedCorners(16)
                )
            )
            .into(iView)
    }
}