package com.axell.marvelcharacters.data.network

import retrofit2.Response
import timber.log.Timber

abstract class BaseClient {
    protected suspend fun <T> getResult(call: suspend () -> Response<T>): Result<T> {
        try {
            val response = call()
            if (response.isSuccessful) {
                val body = response.body()
                Timber.d(body.toString())
                if (body != null) return Result.success(body)
            }
            return error("HTTP ERROR CODE : ${response.code()}")
        } catch (e: Exception) {
            return error(e.message ?: e.toString())
        }
    }

    private fun <T> error(message: String): Result<T> {
        Timber.e(message)
        return Result.error("HTTP ERROR MESSAGE: $message")
    }
}
