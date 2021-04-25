package com.axell.marvelcharacters.repository

import com.axell.marvelcharacters.data.model.CharacterDataWrapper
import com.axell.marvelcharacters.data.network.MarvelClient
import com.axell.marvelcharacters.data.network.Result
import javax.inject.Inject

class CharacterRepository @Inject constructor(private val marvelClient: MarvelClient) {
    suspend fun getCharacters(): Result<CharacterDataWrapper> = marvelClient.getCharacters()
}
