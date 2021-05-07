package com.axell.marvelcharacters.repository

import com.axell.marvelcharacters.core.functional.Result
import com.axell.marvelcharacters.data.model.CharacterDataWrapper
import com.axell.marvelcharacters.data.network.MarvelClient
import javax.inject.Inject

class CharacterRepository @Inject constructor(private val marvelClient: MarvelClient) {
    suspend fun getCharacters(): Result<CharacterDataWrapper> = marvelClient.getCharacters()
}
