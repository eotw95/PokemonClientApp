package com.example.pokemonclientapp.network.model

data class PokemonInfoResponse(
    val id: Int,
    val name: String,
    val sprites: PokemonSpritesResponse
)