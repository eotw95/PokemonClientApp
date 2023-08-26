package com.example.pokemonclientapp.ui.screen.search

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.pokemonclientapp.network.model.PokemonInfoResponse
import com.example.pokemonclientapp.repository.PokeRepository
import kotlinx.coroutines.launch

class SearchViewModel(
    val repo: PokeRepository = PokeRepository()
): ViewModel() {

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

    fun getPokemosInfo(): List<PokemonInfoResponse>? {
        var pokemonsInfo: List<PokemonInfoResponse>? = null
        viewModelScope.launch {
            pokemonsInfo = repo.getPokemonsInfo()
        }
        pokemonsInfo?.let {
            return pokemonsInfo as List<PokemonInfoResponse>
        }
        // Todo: エラーハンドリング
        return null
    }
}