package com.example.moviedboffline.Data

import okhttp3.ResponseBody

data class RestClientResult<out T>(
    val status: Status,
    val data: T? = null,
    val errorMessage: String? = null
) {

    enum class Status {
        SUCCESS,
        ERROR,
        LOADING
    }

    companion object {
        fun <T> success(data: T): RestClientResult<T> {
            return RestClientResult(Status.SUCCESS, data, null)
        }

        fun <T> loading(): RestClientResult<T> {
            return RestClientResult(Status.LOADING)
        }

        fun <T> error(
            message: String,
            data: T? = null,
            errorCode: Int? = null,
            errorBody: ResponseBody? = null
        ): RestClientResult<T> {
            return RestClientResult(
                Status.ERROR,
                errorMessage = message
            )
        }
    }
}