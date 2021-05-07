package com.axell.marvelcharacters.data.network

import com.axell.marvelcharacters.BuildConfig
import com.axell.marvelcharacters.core.functional.Result
import com.axell.marvelcharacters.data.model.CharacterDataWrapper
import timber.log.Timber
import java.math.BigInteger
import java.security.MessageDigest
import javax.inject.Inject

class MarvelClient @Inject constructor(private val marvelService: MarvelService) : BaseClient() {

    suspend fun getCharacters(): Result<CharacterDataWrapper> {
        Timber.d("getCharacters")
        val ts = (System.currentTimeMillis() / 1000).toString()
        val apiKey = BuildConfig.PUBLIC_KEY
        val privateKey = BuildConfig.SECRET_KEY
        val hash = md5(ts + privateKey + apiKey)
        return getResult {
            marvelService.getCharacters(ts, apiKey, hash)
        }
    }

    private fun md5(input: String): String {
        val md = MessageDigest.getInstance("MD5")
        return BigInteger(1, md.digest(input.toByteArray())).toString(16).padStart(32, '0')
    }
}
