package com.bgrfacile.poly_copie

import android.os.Build
import androidx.annotation.RequiresApi
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.itemsIndexed
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.material.icons.filled.AddCircle
import androidx.compose.material.icons.filled.Camera
import androidx.compose.material.icons.filled.Home
import androidx.compose.material.icons.filled.Person
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
import androidx.compose.ui.Alignment
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
    val tabs = listOf("Home", "Create", "Profile")

    Scaffold(
        topBar = { TopBar() },
        content = { paddingValues ->
            when (selectedTab) {
                0 -> HomeScreen(paddingValues = paddingValues, navController = navController)
                1 -> CreatePolyCope(paddingValues = paddingValues, navController = navController)
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
                                    0 -> Icons.Default.Home
                                    1 -> Icons.Default.Add
                                    2 -> Icons.Default.Person
                                    else -> Icons.Default.Home
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
                    Icon(Icons.Default.Camera, contentDescription = "Camera")                }
            }
        }
    )
}

@RequiresApi(Build.VERSION_CODES.O)
@Composable
fun HomeScreen(
    navController: NavController,
    paddingValues: PaddingValues
) {
    val todoList = getFakePolycopie()
    Column(
        modifier = Modifier
            .fillMaxHeight()
            .padding(paddingValues)
    ) {
        LazyColumn {
            itemsIndexed(todoList) { _, todo ->
                PolyCopeItem(todo) {
                    navController.navigate("details/${todo.id}")
                }
            }
        }
    }
}

@Composable
fun PolyCopeItem(item: Polycopie, onClick: () -> Unit) {
    Card(
        modifier = Modifier
            .fillMaxWidth()
            .padding(4.dp)
            .clickable(onClick = onClick),
        elevation = CardDefaults.cardElevation(defaultElevation = 4.dp)
    ) {
        Column(
            modifier = Modifier.padding(8.dp)
        ) {
            Text(
                text = item.name,
                style = MaterialTheme.typography.titleMedium
            )
            Spacer(modifier = Modifier.height(4.dp))
            Text(
                text = item.description,
                style = MaterialTheme.typography.bodyMedium
            )
            Spacer(modifier = Modifier.height(4.dp))
            Text(
                text = "Créé le: ${SimpleDateFormat("dd/MM/yyyy").format(item.createdAt)}",
                style = MaterialTheme.typography.bodySmall
            )
        }
    }
}