package com.example.pokemonclientapp.ui.screen.search

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.pokemonclientapp.network.model.PokemonBasicInfoResponse
import com.example.pokemonclientapp.repository.PokeRepository
import kotlinx.coroutines.launch

class SearchViewModel: ViewModel() {
    private val repo: PokeRepository = PokeRepository()
    private var _pokemonsInfo = MutableLiveData<List<PokemonBasicInfoResponse>>()
    val pokemonsInfo: LiveData<List<PokemonBasicInfoResponse>> = _pokemonsInfo

    init {
        getPokemosInfo()
    }

    fun getPokemonInfo(id: String) {
    }

    fun getPokemosInfo() {
        viewModelScope.launch {
            _pokemonsInfo.value = repo.getPokemonsInfo()?.results
        }
    }
}