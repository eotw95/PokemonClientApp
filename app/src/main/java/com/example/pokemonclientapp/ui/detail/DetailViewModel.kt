package com.example.pokemonclientapp.ui.detail

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.pokemonclientapp.network.model.PokemonInfoResponse
import com.example.pokemonclientapp.repository.PokeRepository
import kotlinx.coroutines.launch

class DetailViewModel: ViewModel() {
    private val repo = PokeRepository()
    private var _pokemonInfo = MutableLiveData<PokemonInfoResponse>()
    val pokemonInfo: LiveData<PokemonInfoResponse> = _pokemonInfo

    fun getPokemonInfo(id:String) {
        viewModelScope.launch {
            _pokemonInfo.value = repo.getPokemonInfo(id)
        }
    }
}