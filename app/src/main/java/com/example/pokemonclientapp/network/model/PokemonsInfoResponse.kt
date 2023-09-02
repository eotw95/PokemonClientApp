package com.example.pokemonclientapp.network.model

import com.squareup.moshi.Json

data class PokemonsInfoResponse(
    @Json(name = "pokemon_entries")val pokemonEntries: List<PokemonEntriesResponse>
)