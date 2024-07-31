package com.bgrfacile.poly_copie

import android.os.Build
import androidx.annotation.RequiresApi
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.itemsIndexed
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.AddPhotoAlternate
import androidx.compose.material.icons.filled.Camera
import androidx.compose.material.icons.filled.Favorite
import androidx.compose.material.icons.filled.Info
import androidx.compose.material.icons.filled.Menu
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.FloatingActionButton
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.NavigationBar
import androidx.compose.material3.NavigationBarItem
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.bgrfacile.poly_copie.screen.data.Polycopie
import com.bgrfacile.poly_copie.screen.data.getFakePolycopie
import java.text.SimpleDateFormat

@RequiresApi(Build.VERSION_CODES.O)
@Composable
fun ListPolyCopePage(
    navController: NavController
) {
    var selectedTab by remember { mutableIntStateOf(0) }
    val tabs = listOf("Home", "Add", "Profile")

    Scaffold(
        topBar = { TopBar() },
        content = { paddingValues ->
            when (selectedTab) {
                0 -> HomeScreen(paddingValues = paddingValues, navController = navController)
                1 -> CreatePolyCope(paddingValues = paddingValues, navController = navController, onSubmit = { _, _, _, _, _ -> })
                2 -> ProfilePolyCope(paddingValues = paddingValues, navController = navController)
            }
        },
        bottomBar = {
            NavigationBar {
                tabs.forEachIndexed { index, item ->
                    NavigationBarItem(
                        icon = {
                            Icon(
                                imageVector = when (index) {
                                    0 -> Icons.Default.Menu
                                    1 -> Icons.Default.AddPhotoAlternate
                                    2 -> Icons.Default.Favorite
                                    else -> Icons.Default.Info
                                },
                                contentDescription = item,
                                tint = if (selectedTab == index) MaterialTheme.colorScheme.primary else MaterialTheme.colorScheme.onPrimary

                            )
                        },
                        label = { Text(item) },
                        selected = selectedTab == index,
                        onClick = { selectedTab = index }
                    )
                }
            }
        },
        floatingActionButton = {
            if (selectedTab == 1) {
                FloatingActionButton(
                    onClick = { navController.navigate("takePhoto") },
                ) {
                    Icon(Icons.Default.Camera, contentDescription = "Camera")
                }
            }
        }
    )
}