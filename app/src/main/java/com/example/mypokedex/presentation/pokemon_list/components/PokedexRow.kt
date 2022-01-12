package com.example.mypokedex.presentation.pokemon_list.components

import androidx.compose.foundation.layout.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.example.mypokedex.data.model.PokedexListEntry

/**
 * PokedexRow has two rectangles with pokemon image and name.
 * If we have an uneven number of pokemon, the second rectangle
 * will be empty.
 *
 * Example: If we have 5 pokemon, we will have 3 rows (indexes 0, 1, 2).
 * 5 >= 0 * 2 + 2 -> add a second rectangle
 * 5 >= 1 * 2 + 2 -> add a second rectangle
 * 5 < 2 * 2 + 2 -> add Spacer which represents an empty rectangle
 *
 * **/

@Composable
fun PokedexRow(
    rowIndex: Int,
    entries: List<PokedexListEntry>,
    navController: NavController
) {
    Column {
        Row {
            PokedexEntry(
                entry = entries[rowIndex * 2],
                navController = navController,
                modifier = Modifier.weight(1f)
            )
            Spacer(modifier = Modifier.width(16.dp))
            if (entries.size >= rowIndex * 2 + 2) {
                PokedexEntry(
                    entry = entries[rowIndex * 2 + 1],
                    navController = navController,
                    modifier = Modifier.weight(1f)
                )
            } else {
                Spacer(modifier = Modifier.weight(1f))
            }
        }
        Spacer(modifier = Modifier.height(16.dp))
    }
}