package com.example.mypokedex.presentation

sealed class Screen(val route: String) {
    object PokemonListScreen: Screen("pokemon_list_screen")
    object PokemonDetailsScreen: Screen("pokemon_details_screen")
}
