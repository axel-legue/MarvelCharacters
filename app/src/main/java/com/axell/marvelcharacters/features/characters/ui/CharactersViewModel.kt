package com.axell.marvelcharacters.features.characters.ui

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.viewModelScope
import com.axell.marvelcharacters.core.functional.ImageVariants
import com.axell.marvelcharacters.core.interactor.UseCase
import com.axell.marvelcharacters.core.platform.BaseViewModel
import com.axell.marvelcharacters.features.characters.model.Character
import com.axell.marvelcharacters.features.characters.modelview.CharacterView
import com.axell.marvelcharacters.features.characters.usecase.GetCharacters
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class CharactersViewModel @Inject constructor(private val getCharacters: GetCharacters) : BaseViewModel() {

    private var _characters: MutableLiveData<List<CharacterView>> = MutableLiveData()
    fun characters(): LiveData<List<CharacterView>> = _characters

    fun loadCharacters() = getCharacters(UseCase.None(), viewModelScope) {

        it.fold(::handleFailure, ::handleCharacterList)
    }

    private fun handleCharacterList(characters: List<Character>) {
        _characters.postValue(characters.map {
            val thumbnail: String =
                StringBuilder().append(it.thumbnail.path).append("/").append(ImageVariants.STANDARD_MEDIUM.variant).append(".").append(it.thumbnail.extension).toString()
            CharacterView(it.id, it.name, thumbnail)
        })
    }
}
