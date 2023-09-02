package com.example.pokemonclientapp.ui.detail

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.livedata.observeAsState
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.compose.viewModel
import coil.compose.AsyncImage
import com.example.pokemonclientapp.network.model.PokemonInfoResponse

@Composable
fun DetailScreen(
    id: Int,
    vm: DetailViewModel = viewModel(),
    onClickButton: () -> Unit
) {
    val observePokemonInfo = vm.pokemonInfo.observeAsState()
    val pokemonInfo = observePokemonInfo.value

    Column(
        modifier = Modifier.fillMaxWidth(),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        vm.getPokemonInfo(id.toString())
        AsyncImage(
            modifier = Modifier
                .width(300.dp)
                .height(300.dp),
            model = pokemonInfo?.sprites?.frontDefault,
            contentDescription = null,
            contentScale = ContentScale.Crop
        )
        AsyncImage(
            modifier = Modifier
                .width(300.dp)
                .height(300.dp),
            model = pokemonInfo?.sprites?.backDefault,
            contentDescription = null,
            contentScale = ContentScale.Crop
        )
        Button(onClick = onClickButton) {
            Text(text = "Back")
        }
    }
}