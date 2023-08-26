package com.example.pokemonclientapp.ui.screen.search

import android.util.Log
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.livedata.observeAsState
import androidx.lifecycle.viewmodel.compose.viewModel
import java.lang.reflect.Modifier

@Composable
fun SearchScreen(
    modifier: Modifier = Modifier(),
    vm: SearchViewModel = viewModel()
) {
    Log.d("SearchScreen", "pokemonsInfo=${vm.pokemonsInfo}")
    val observePokemonsInfo = vm.pokemonsInfo.observeAsState()
    val pokemonsInfo = observePokemonsInfo.value

    pokemonsInfo?.let {
        LazyColumn(content = {
        items(it) {pokemonInfo ->
            Text(text = "${pokemonInfo.name}")
        }
    })
    }
}