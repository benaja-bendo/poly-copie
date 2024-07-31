package com.bgrfacile.poly_copie

import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.gestures.detectTransformGestures
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.offset
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.pager.HorizontalPager
import androidx.compose.foundation.pager.rememberPagerState
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.scale
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.input.pointer.pointerInput
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.IntOffset
import androidx.compose.ui.unit.dp
import com.bgrfacile.poly_copie.screen.data.getFakePolycopieById
import kotlin.math.roundToInt

@OptIn(ExperimentalFoundationApi::class)
@Composable
fun DetailsPolyCope(
    itemId: String
) {
    val item = itemId.toIntOrNull()?.let { getFakePolycopieById(it) }
    val pagerState = rememberPagerState(pageCount = { item?.imageResources?.size ?: 0 })

    Scaffold(
        topBar = { TopBar() },
        content = { paddingValues ->
            Column(
                modifier = Modifier
                    .fillMaxHeight()
                    .padding(paddingValues)
            ) {
                item?.let {
                    HorizontalPager(state = pagerState) { page ->
                        val imageResource = item.imageResources[page]
                        ZoomableImageCard(imageResource)
                    }
                }
            }
        }
    )
}

@Composable
fun ZoomableImageCard(imageResource: Int) {
    var scale by remember { mutableStateOf(1f) }
    var offsetX by remember { mutableStateOf(0f) }
    var offsetY by remember { mutableStateOf(0f) }


    Box(
        modifier = Modifier
            .fillMaxSize()
            .background(Color.Black)
            .padding(4.dp)
            .clickable { /* TODO: Action on image click */ },
        contentAlignment = Alignment.Center
    )
    {
        Box(
            modifier = Modifier
                .background(Color.Gray)
                .padding(4.dp)
                .pointerInput(Unit) {
                    detectTransformGestures { centroid, pan, zoom, rotation ->
                        scale = maxOf(1f, scale * zoom)  // Limit zoom to 1x minimum
                        offsetX += pan.x
                        offsetY += pan.y
                    }
                }
        ) {
            Image(
                painter = painterResource(id = imageResource),
                contentDescription = null,
                modifier = Modifier
                    .scale(scale)
                    .offset { IntOffset(offsetX.roundToInt(), offsetY.roundToInt()) }
            )
        }
    }
}