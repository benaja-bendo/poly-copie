package com.bgrfacile.poly_copie

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Card
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp

@Composable
fun DetailsPolycopie(itemId: String, paddingValues: PaddingValues) {

    val item = itemId.toIntOrNull()?.let { getFakePolycopieById(it) }
    Column(
        modifier = Modifier
            .fillMaxHeight()
            .padding(paddingValues)
    ) {
        if (item != null) {
            Card(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(4.dp),
                onClick = { /*TODO*/ }
            ) {
                Text(text = item.name)
            }
        }
    }
}