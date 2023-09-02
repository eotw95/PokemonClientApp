package com.example.pokemonclientapp.network.model

import com.squareup.moshi.Json

data class PokemonEntriesResponse(
    @Json(name = "entry_number")val entryNumber: Int,
    @Json(name = "pokemon_species")val pokemonSpecies: PokemonSpeciesResponse
)