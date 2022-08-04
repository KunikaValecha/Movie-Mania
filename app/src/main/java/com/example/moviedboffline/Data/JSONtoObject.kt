package com.example.moviedboffline.Data

data class JSONtoObject(
    val page: Int,
    val results: List<Result>,
    val total_pages: Int,
    val total_results: Int
)