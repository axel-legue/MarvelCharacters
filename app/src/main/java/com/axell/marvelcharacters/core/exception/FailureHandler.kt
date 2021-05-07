package com.axell.marvelcharacters.core.exception

interface FailureHandler {
    fun getFailure(throwable: Throwable): Failure
}
