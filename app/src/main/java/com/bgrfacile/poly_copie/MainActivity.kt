package com.bgrfacile.poly_copie

import android.os.Build
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.annotation.RequiresApi
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Search
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import com.bgrfacile.poly_copie.ui.theme.PolycopieTheme

class MainActivity : ComponentActivity() {
    @OptIn(ExperimentalMaterial3Api::class)
    @RequiresApi(Build.VERSION_CODES.O)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            PolycopieTheme {
                Scaffold(
                    topBar = {
                        TopAppBar(
                            title = { Text(text = "poly-copie") },
                            actions = {
                                IconButton(onClick = { /* Gérer le clic ici */ }) {
                                    Icon(Icons.Filled.Search, contentDescription = "Rechercher")
                                }
                            }
                        )
                    },
                    content = { paddingValues ->
                        TodoListPage(paddingValues)
                    }
                )
            }
        }
    }
}
