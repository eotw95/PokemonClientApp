package com.example.pokemonclientapp.ui.component

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.pokemonclientapp.ui.theme.Purple80

@Composable
fun BasicInfoCell(
    modifier: Modifier = Modifier,
    word: String,
    onClickCell: () -> Unit
) {
    Column(
        modifier = modifier
            .padding(horizontal = 16.dp, vertical = 10.dp)
            .fillMaxWidth()
            .background(Purple80)
            .clickable(onClick = onClickCell)
    ) {
        Text(
            modifier = modifier
                .padding(horizontal = 16.dp, vertical = 10.dp),
            fontSize = 30.sp,
            text = "No. #")
        Spacer(modifier = Modifier.padding(vertical = 2.dp))
        Text(
            modifier = modifier
                .padding(horizontal = 16.dp, vertical = 10.dp),
            fontSize = 40.sp,
            text = "$word")
    }
}