package com.axell.marvelcharacters.data.network

data class Result<out T>(
    val status: Status,
    val data: T?,
    val message: String?,
    val progress: Int?
) {
    enum class Status {
        SUCCESS,
        ERROR,
        LOADING
    }

    companion object {
        fun <T> success(data: T): Result<T> {
            return Result(Status.SUCCESS, data, null, null)
        }

        fun <T> error(message: String, data: T? = null, progress: Int? = null): Result<T> {
            return Result(Status.ERROR, data, message, null)
        }

        fun <T> loading(data: T? = null, progress: Int? = null): Result<T> {
            return Result(Status.LOADING, data, null, progress)
        }
    }
}
