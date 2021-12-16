package com.axell.marvelcharacters.features.characters.service

import retrofit2.Retrofit
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class CharacterService @Inject constructor(retrofit: Retrofit) : CharactersApi {
    private val charactersApi by lazy { retrofit.create(CharactersApi::class.java) }

    override fun getCharacters(ts: String, apikey: String, hash: String, limit: Int) = charactersApi.getCharacters(ts, apikey, hash, limit)
}
