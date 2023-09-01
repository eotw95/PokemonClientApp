package com.example.pokemonclientapp.ui.detail

import androidx.compose.foundation.layout.Column
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import coil.compose.AsyncImage
import com.example.pokemonclientapp.network.model.PokemonInfoResponse

@Composable
fun DetailScreen(
    info: PokemonInfoResponse
) {
    Column {
        AsyncImage(
            model = info.sprites.frontDefault,
            contentDescription = null
        )
        Text(text = "DetailScreen")
    }
}