package com.example.pokemonclientapp.ui.screen.search

import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.runtime.Composable
import androidx.compose.runtime.livedata.observeAsState
import androidx.compose.ui.Modifier
import androidx.lifecycle.viewmodel.compose.viewModel
import com.example.pokemonclientapp.ui.component.BasicInfoCell

@Composable
fun SearchScreen(
    modifier: Modifier = Modifier,
    vm: SearchViewModel = viewModel(),
    onClick: (String) -> Unit
) {
    val observePokemonsInfo = vm.pokemonsInfo.observeAsState()
    val pokemonsInfo = observePokemonsInfo.value

    pokemonsInfo?.let {
        LazyColumn(
            content = {
            items(it) {pokemonInfo ->
                BasicInfoCell(
                    info = pokemonInfo,
                    onClickCell = { url ->
                        onClick(url)
                    }
                )
            }
        })
    }
}