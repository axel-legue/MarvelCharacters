package com.axell.marvelcharacters.repository

import com.axell.marvelcharacters.BuildConfig
import com.axell.marvelcharacters.core.exception.Failure
import com.axell.marvelcharacters.core.functional.Either
import com.axell.marvelcharacters.core.functional.Either.Left
import com.axell.marvelcharacters.core.functional.Either.Right
import com.axell.marvelcharacters.core.platform.NetworkHandler
import com.axell.marvelcharacters.data.model.CharacterDataContainer
import com.axell.marvelcharacters.data.model.CharacterDataWrapper
import com.axell.marvelcharacters.features.MarvelService
import retrofit2.Call
import timber.log.Timber
import java.math.BigInteger
import java.security.MessageDigest
import javax.inject.Inject

interface CharacterRepository {
    fun characters(): Either<Failure, CharacterDataContainer>

    class Network @Inject constructor(
        private val networkHandler: NetworkHandler,
        private val service: MarvelService
    ) : CharacterRepository {
        override fun characters(): Either<Failure, CharacterDataContainer> {
            // TODO : Move static params
            Timber.d("getCharacters")
            val ts = (System.currentTimeMillis() / 1000).toString()
            val apiKey = BuildConfig.PUBLIC_KEY
            val privateKey = BuildConfig.SECRET_KEY
            val hash = md5(ts + privateKey + apiKey)

            return when (networkHandler.isNetworkAvailable()) {
                true -> request(
                    service.getCharacters(ts = ts, apikey = apiKey, hash = hash),
                    { it.characterDataContainer },
                    CharacterDataWrapper()
                )
                false -> Left(Failure.NetworkConnectionError)
            }
        }


        private fun <T, R> request(
            call: Call<T>,
            transform: (T) -> R,
            default: T
        ): Either<Failure, R> {
            return try {
                val response = call.execute()
                when (response.isSuccessful) {
                    true -> Right(transform((response.body() ?: default)))
                    false -> Left(Failure.ServerError)
                }
            } catch (exception: Throwable) {
                Left(Failure.ServerError)
            }
        }

        private fun md5(input: String): String {
            val md = MessageDigest.getInstance("MD5")
            return BigInteger(1, md.digest(input.toByteArray())).toString(16).padStart(32, '0')
        }
    }
}
