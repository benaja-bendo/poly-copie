package com.bgrfacile.poly_copie

import android.os.Build
import androidx.annotation.RequiresApi
import java.time.Instant
import java.util.Date

data class Polycopie(
    val id: Int,
    val name: String,
    val description: String,
    val imageResources: List<Int>,
    val createdAt: Date,
)


@RequiresApi(Build.VERSION_CODES.O)
fun getFakePolycopie(): List<Polycopie> {
    return listOf(
        Polycopie(
            1,
            "Polycopie 1",
            "Polycopie 1",
            listOf(
                R.drawable.image1, R.drawable.image1, R.drawable.image1
            ),
            Date.from(Instant.now()),
        ),
        Polycopie(
            2, "Polycopie 2", "Polycopie 2", listOf(
                R.drawable.image1, R.drawable.image1, R.drawable.image1
            ), Date.from(Instant.now())
        ),
        Polycopie(
            3, "Polycopie 3", "Polycopie 3", listOf(
                R.drawable.image1, R.drawable.image1, R.drawable.image1
            ), Date.from(Instant.now())
        ),
        Polycopie(
            4, "Polycopie 4", "Polycopie 4", listOf(
                R.drawable.image1, R.drawable.image1, R.drawable.image1
            ), Date.from(Instant.now())
        ),
        Polycopie(
            5, "Polycopie 5", "Polycopie 5", listOf(
                R.drawable.image1, R.drawable.image1, R.drawable.image1
            ), Date.from(Instant.now())
        ),
        Polycopie(
            6, "Polycopie 6", "Polycopie 6", listOf(
                R.drawable.image1, R.drawable.image1, R.drawable.image1
            ), Date.from(Instant.now())
        ),
        Polycopie(
            7, "Polycopie 7", "Polycopie 7", listOf(
                R.drawable.image1, R.drawable.image1, R.drawable.image1
            ), Date.from(Instant.now())
        ),
        Polycopie(
            8, "Polycopie 8", "Polycopie 8", listOf(
                R.drawable.image1, R.drawable.image1, R.drawable.image1
            ), Date.from(Instant.now())
        ),
        Polycopie(
            9, "Polycopie 9", "Polycopie 9", listOf(
                R.drawable.image1, R.drawable.image1, R.drawable.image1
            ), Date.from(Instant.now())
        ),
        Polycopie(
            10, "Polycopie 10", "Polycopie 10", listOf(
                R.drawable.image1, R.drawable.image1, R.drawable.image1
            ), Date.from(Instant.now())
        ),
    )
}

fun getFakePolycopieById(id: Int): Polycopie? {
    return getFakePolycopie().find { it.id == id }
}