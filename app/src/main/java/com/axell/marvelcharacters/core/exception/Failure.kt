package com.axell.marvelcharacters.core.exception

sealed class Failure {
    object NetworkConnectionError : Failure()
    object ServerError : Failure()
    object Unknown : Failure()
}
