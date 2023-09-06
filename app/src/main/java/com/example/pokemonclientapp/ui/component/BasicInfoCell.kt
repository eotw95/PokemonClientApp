package com.example.pokemonclientapp.ui.component

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Divider
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.pokemonclientapp.network.model.PokemonEntriesResponse

@Composable
fun BasicInfoCell(
    modifier: Modifier = Modifier,
    info: PokemonEntriesResponse,
    onClickCell: (Int) -> Unit
) {
    Column(
        modifier = modifier
            .padding(horizontal = 16.dp, vertical = 10.dp)
            .fillMaxWidth()
            .clickable(onClick = {
                onClickCell(info.entryNumber)
            })
    ) {
        Text(
            modifier = modifier
                .padding(horizontal = 16.dp),
            fontSize = 15.sp,
            text = "No. ${info.entryNumber}")
        Spacer(modifier = Modifier.padding(vertical = 2.dp))
        Text(
            modifier = modifier
                .padding(horizontal = 16.dp),
            fontSize = 20.sp,
            text = info.pokemonSpecies.name
        )
    }
    Divider()
}