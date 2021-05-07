package com.axell.marvelcharacters.core.exception

sealed class Failure {
    object NetworkConnection : Failure()
    object Server : Failure()
    object Obsolete : Failure()
    object Unauthorized : Failure()
    object Unavailable : Failure()
    object Unknown : Failure()
}
