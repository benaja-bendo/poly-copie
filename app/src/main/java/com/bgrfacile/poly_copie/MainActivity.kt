package com.bgrfacile.poly_copie

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.bgrfacile.poly_copie.ui.theme.PolycopieTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            PolycopieTheme {
                Scaffold(modifier = Modifier.fillMaxSize()) {  paddingValues ->
                    Text(text = "Hello World", modifier = Modifier.padding(paddingValues))
                }
            }
        }
    }
}
