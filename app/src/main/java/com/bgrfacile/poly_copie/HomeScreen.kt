package com.bgrfacile.poly_copie

import android.os.Build
import androidx.annotation.RequiresApi
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.itemsIndexed
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import com.bgrfacile.poly_copie.screen.data.Polycopie
import com.bgrfacile.poly_copie.screen.data.getFakePolycopie

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
    /*Card(
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
       }*/

    Card(
        shape = RoundedCornerShape(8.dp),
        elevation = CardDefaults.cardElevation(4.dp),
        modifier = Modifier
            .fillMaxWidth()
            .padding(8.dp)
    ) {
        Row(
            modifier = Modifier
                .background(MaterialTheme.colorScheme.surface)
                .padding(16.dp)
                .fillMaxWidth(),
            verticalAlignment = Alignment.CenterVertically
        ) {
            Image(
//                painter = if (imageUri != null) {
//                    rememberAsyncImagePainter(
//                        model = ImageRequest.Builder(LocalContext.current)
//                            .data(imageUri)
//                            .crossfade(true)
//                            .build()
//                    )
//                } else {
//                    painterResource(id = android.R.drawable.ic_menu_gallery)
//                },
                painter = painterResource(id = android.R.drawable.ic_menu_gallery),
                contentDescription = "PolyCope Image",
                contentScale = ContentScale.Crop,
                modifier = Modifier
                    .size(64.dp)
                    .background(MaterialTheme.colorScheme.primary.copy(alpha = 0.1f))
                    .padding(4.dp)
            )

            Spacer(modifier = Modifier.width(16.dp))

            Column(
                modifier = Modifier.weight(1f)
            ) {
                Text(
                    text = item.name,
                    fontSize = 18.sp,
                    fontWeight = FontWeight.Bold,
                    color = MaterialTheme.colorScheme.onSurface
                )
                Text(
                    text = "Author: BENJI",
                    fontSize = 14.sp,
                    color = MaterialTheme.colorScheme.onSurface.copy(alpha = 0.7f)
                )
                Text(
                    text = "Year: 2001",
                    fontSize = 14.sp,
                    color = MaterialTheme.colorScheme.onSurface.copy(alpha = 0.7f)
                )
                Text(
                    text = "Department: CONGO",
                    fontSize = 14.sp,
                    color = MaterialTheme.colorScheme.onSurface.copy(alpha = 0.7f)
                )
            }
        }
    }
}
