package com.axell.marvelcharacters.ui.character

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.axell.marvelcharacters.data.model.Character
import com.axell.marvelcharacters.data.network.Result
import com.axell.marvelcharacters.repository.CharacterRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import timber.log.Timber
import javax.inject.Inject

@HiltViewModel
class CharactersViewModel @Inject constructor(
    private val characterRepository: CharacterRepository
) : ViewModel() {

    private var charactersLiveData = MutableLiveData<List<Character>>()
    fun characters(): LiveData<List<Character>> = charactersLiveData

    fun getCharacters() {
        viewModelScope.launch(Dispatchers.IO) {
            val result = characterRepository.getCharacters()
            if (result.data != null) {
                when (result.status) {
                    Result.Status.SUCCESS -> {
                        Timber.d("${result.data}")
                        charactersLiveData.postValue(result.data.characterDataContainer.Characters)
                    }
                    Result.Status.ERROR -> {
                        Timber.d("${result.message}")
                    }
                }
            }
        }
    }
}
