package com.example.pokemonclientapp.network

import com.example.pokemonclientapp.network.model.PokemonInfoResponse
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Path

interface PokeApi {
    companion object {
        const val BASE_URL = "https://pokeapi.co/api/v2/"
    }

    @GET("pokemon/{id}")
    suspend fun getPokemonInfo(@Path("id") id: String): Response<PokemonInfoResponse>
}