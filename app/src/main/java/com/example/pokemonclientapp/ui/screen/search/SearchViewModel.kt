package com.example.pokemonclientapp.ui.screen.search

import android.util.Log
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.pokemonclientapp.network.model.PokemonBasicInfoResponse
import com.example.pokemonclientapp.network.model.PokemonInfoResponse
import com.example.pokemonclientapp.repository.PokeRepository
import kotlinx.coroutines.launch

class SearchViewModel(
    val repo: PokeRepository = PokeRepository()
): ViewModel() {
    var pokemonsInfo: List<PokemonBasicInfoResponse>? = null

    init {
        getPokemosInfo()
    }

    fun getPokemonInfo(id: String): PokemonInfoResponse? {
        var pokemonInfo: PokemonInfoResponse? = null
        viewModelScope.launch {
            pokemonInfo = repo.getPokemonInfo(id)
        }
        pokemonInfo?.let {
            return pokemonInfo as PokemonInfoResponse
        }
        // Todo:エラーハンドリング
        return null

    }

    fun getPokemosInfo() {
        viewModelScope.launch {
            Log.d("SearchViewModel", "pokemonsInfo=${repo.getPokemonsInfo()?.results}")
            pokemonsInfo = repo.getPokemonsInfo()?.results
        }
    }
}