package com.example.pokemonclientapp.network

import com.example.pokemonclientapp.network.model.PokemonInfoResponse
import com.example.pokemonclientapp.network.model.PokemonsInfoResponse
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Path

interface PokeApi {
    companion object {
        const val BASE_URL = "https://pokeapi.co/api/v2/"
    }

    @GET("pokemon/{name}")
    suspend fun getPokemonInfo(@Path("name") name: String): Response<PokemonInfoResponse>

    @GET("pokedex/national/")
    suspend fun getPokemonsInfo(): Response<PokemonsInfoResponse>
}