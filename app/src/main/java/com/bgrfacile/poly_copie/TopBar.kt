package com.bgrfacile.poly_copie

import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Search
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.runtime.Composable

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun TopBar(){
    TopAppBar(
        title = { Text(text = "poly-copie") },
//        actions = {
//            IconButton(onClick = { /* Gérer le clic ici */ }) {
//                Icon(Icons.Filled.Search, contentDescription = "Rechercher")
//            }
//        }
    )
}