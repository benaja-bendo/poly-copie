package com.bgrfacile.poly_copie

import android.os.Build
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.annotation.RequiresApi
import androidx.compose.material3.Scaffold
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.bgrfacile.poly_copie.ui.theme.PolycopieTheme

class MainActivity : ComponentActivity() {

    @RequiresApi(Build.VERSION_CODES.O)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            PolycopieTheme {
                val navController = rememberNavController()

                Scaffold(
                    topBar = {topBar()},
                    content = { paddingValues ->
                        NavHost(navController = navController, startDestination = "main") {
                            composable("main") { TodoListPage(navController, paddingValues) }
                            composable("details/{itemId}") { backStackEntry ->
                                val itemId = backStackEntry.arguments?.getString("itemId")
                                DetailsPolycopie(itemId ?: "",paddingValues)
                            }
                        }
                    }
                )
            }
        }
    }
}
