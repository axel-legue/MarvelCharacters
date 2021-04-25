package com.axell.marvelcharacters.ui

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.axell.marvelcharacters.data.network.Result
import com.axell.marvelcharacters.repository.CharacterRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import timber.log.Timber
import javax.inject.Inject

@HiltViewModel
class MainViewModel @Inject constructor(
    private val characterRepository: CharacterRepository
) : ViewModel() {

    fun getCharacters() {
        viewModelScope.launch(Dispatchers.IO) {
            val result = characterRepository.getCharacters()
            if (result.data != null) {
                when (result.status) {
                    Result.Status.SUCCESS -> {
                        Timber.d("${result.data}")
                    }
                    Result.Status.ERROR -> {
                        Timber.d("${result.message}")
                    }
                }
            }
        }
    }
}
