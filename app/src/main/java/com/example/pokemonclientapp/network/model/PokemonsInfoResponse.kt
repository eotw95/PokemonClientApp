package com.example.pokemonclientapp.network.model

data class PokemonsInfoResponse(
    val count: Int,
    val next: String,
    val previous: String,
    val results: List<PokemonBasicInfoResponse>
)