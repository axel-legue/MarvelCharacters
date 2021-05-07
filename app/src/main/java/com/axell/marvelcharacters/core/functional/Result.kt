package com.axell.marvelcharacters.core.functional

import com.axell.marvelcharacters.core.exception.Failure

sealed class Result<T> {
    data class Success<T>(val data: T) : Result<T>()

    data class Error<T>(val error: Failure) : Result<T>()
}

