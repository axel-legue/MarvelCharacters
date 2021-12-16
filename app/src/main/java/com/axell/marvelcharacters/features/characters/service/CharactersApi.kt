package com.axell.marvelcharacters.features.characters.service

import com.axell.marvelcharacters.features.characters.entity.CharacterWrapperEntity
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Query

interface CharactersApi {
    @GET("/v1/public/characters")
    fun getCharacters(
        @Query("ts") ts: String,
        @Query("apikey") apikey: String,
        @Query("hash") hash: String,
        @Query("limit") limit: Int = 100,
    ): Call<CharacterWrapperEntity>
}