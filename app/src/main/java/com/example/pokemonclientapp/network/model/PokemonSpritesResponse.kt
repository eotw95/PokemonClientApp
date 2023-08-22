package com.example.pokemonclientapp.network.model

import com.squareup.moshi.Json

data class PokemonSpritesResponse(
    @Json(name = "front_default") val frontDefault: String,
    @Json(name = "back_default") val backDefault: String
)