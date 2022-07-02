package com.example.moviestestproject.core.utils

import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import retrofit2.Response

private const val BODY_IS_NULL_ERROR = "Body is null error"

suspend fun <T> apiRequest(apiCall: suspend () -> Response<T>): Result<T> {
    return try {
        val response = withContext(Dispatchers.IO) {
            apiCall()
        }
        if (response.isSuccessful) {
            Result.Success(value = response.body())
        } else {
            Result.Error(message = response.errorBody().toString())
        }
    } catch (e: Exception) {
        Result.Error(message = e.message.toString())
    }
}

sealed class Result<out T> {
    class Success<out T>(val value: T?) : Result<T>()
    class Error(val message: String) : Result<Nothing>()
}