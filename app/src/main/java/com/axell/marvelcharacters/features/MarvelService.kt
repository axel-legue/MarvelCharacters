package com.axell.marvelcharacters.data.network

import com.axell.marvelcharacters.data.model.CharacterDataWrapper
import com.axell.marvelcharacters.features.CharactersApi
import retrofit2.Call
import retrofit2.Retrofit
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class MarvelService @Inject constructor(retrofit: Retrofit) : CharactersApi {

    private val charactersApi by lazy { retrofit.create(CharactersApi::class.java) }
    override fun getCharacters(ts: String, apikey: String, hash: String, limit: Int): Call<CharacterDataWrapper> {
        return charactersApi.getCharacters(ts, apikey, hash, limit)
    }

}
