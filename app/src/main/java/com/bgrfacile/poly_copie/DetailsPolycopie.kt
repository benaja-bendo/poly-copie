package com.bgrfacile.poly_copie

import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material3.Card
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.painter.Painter
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

@Composable
fun DetailsPolycopie(itemId: String, paddingValues: PaddingValues) {
    val item = itemId.toIntOrNull()?.let { getFakePolycopieById(it) }

    Column(
        modifier = Modifier
            .fillMaxHeight()
            .padding(paddingValues)
    ) {
        item?.let {
            Text(
                text = it.name,
                fontSize = 24.sp,
                modifier = Modifier.padding(16.dp)
            )
            LazyColumn(
                contentPadding = PaddingValues(16.dp),
                verticalArrangement = Arrangement.spacedBy(8.dp)
            ) {
                items(it.imageResources.size) { index ->
                    val imageResource = it.imageResources[index]
                    ImageCard(imageResource)
                }
            }
        }
    }
}

@Composable
fun ImageCard(imageResource: Int) {
    Card(
        modifier = Modifier
            .fillMaxWidth()
            .padding(4.dp)
            .clickable { /* TODO: Action on image click */ }
    ) {
        val painter: Painter = painterResource(id = imageResource)
        Image(
            painter = painter,
            contentDescription = null, // Provide a description for accessibility
            modifier = Modifier
                .fillMaxWidth()
                .height(200.dp)
        )
    }
}