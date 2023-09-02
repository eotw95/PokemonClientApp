package com.example.pokemonclientapp.repository

import com.example.pokemonclientapp.network.PokeDataSourceImpl
import com.example.pokemonclientapp.network.model.PokemonInfoResponse
import com.example.pokemonclientapp.network.model.PokemonsInfoResponse

class PokeRepository(
    private val pokeDataSource: PokeDataSourceImpl = PokeDataSourceImpl()
) {

    suspend fun getPokemonInfo(name: String): PokemonInfoResponse {
        return pokeDataSource.getPokemonInfo(name)
    }

    suspend fun getPokemonsInfo(): PokemonsInfoResponse {
        return pokeDataSource.getPokemonsInfo()
    }
}