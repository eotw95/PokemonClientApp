package com.example.pokemonclientapp.ui.screen.search

import android.util.Log
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.lifecycle.viewmodel.compose.viewModel
import java.lang.reflect.Modifier

@Composable
fun SearchScreen(
    modifier: Modifier = Modifier(),
    vm: SearchViewModel = viewModel()
) {
    Log.d("SearchScreen", "pokemonsInfo=${vm.pokemonsInfo}")
    vm.pokemonsInfo?.let { pokemonsInfo ->
        Log.d("SearchScreen", "pokemonsInfo=$pokemonsInfo")
        LazyColumn(content = {
            items(pokemonsInfo) { pokemonInfo ->
                Log.d("SearchScreen", "pokemonInfo=$pokemonInfo")
                Text(text = "${pokemonInfo.name}")
            }
        })
    }
}