package com.example.pokemonclientapp.network

import com.example.pokemonclientapp.network.model.PokemonInfoResponse
import com.example.pokemonclientapp.network.model.PokemonsInfoResponse

interface PokeDataSource {
    suspend fun getPokemonInfo(name: String): PokemonInfoResponse

    suspend fun getPokemonsInfo(): PokemonsInfoResponse
}