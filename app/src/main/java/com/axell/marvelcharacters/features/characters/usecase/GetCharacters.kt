package com.axell.marvelcharacters.features.characters.usecase

import com.axell.marvelcharacters.core.exception.Failure
import com.axell.marvelcharacters.core.functional.Either
import com.axell.marvelcharacters.core.interactor.UseCase
import com.axell.marvelcharacters.core.interactor.UseCase.None
import com.axell.marvelcharacters.features.characters.model.Character
import com.axell.marvelcharacters.features.characters.repository.CharacterRepository
import javax.inject.Inject

class GetCharacters @Inject constructor(private val characterRepository: CharacterRepository) : UseCase<List<Character>, None>() {

    override suspend fun run(params: None): Either<Failure, List<Character>> = characterRepository.characters()


}
