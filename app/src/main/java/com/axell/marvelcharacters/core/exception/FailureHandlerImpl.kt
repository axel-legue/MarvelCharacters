package com.axell.marvelcharacters.core.exception

import retrofit2.HttpException
import java.io.IOException
import java.net.HttpURLConnection
import javax.inject.Inject

class FailureHandlerImpl @Inject constructor() : FailureHandler {
    override fun getFailure(throwable: Throwable): Failure {
        return when (throwable) {
            is IOException -> Failure.Unknown
            is HttpException -> {
                when (throwable.code()) {
                    HttpURLConnection.HTTP_UNAUTHORIZED -> Failure.Unauthorized
                    HttpURLConnection.HTTP_NOT_ACCEPTABLE -> Failure.Obsolete
                    HttpURLConnection.HTTP_INTERNAL_ERROR, HttpURLConnection.HTTP_NOT_IMPLEMENTED, HttpURLConnection.HTTP_BAD_GATEWAY, HttpURLConnection.HTTP_UNAVAILABLE, HttpURLConnection.HTTP_GATEWAY_TIMEOUT, HttpURLConnection.HTTP_VERSION -> Failure.Server
                    else -> {
                        Failure.Unknown
                    }
                }
            }
            else -> Failure.Unknown
        }
    }
}
