package com.example.mypokedex

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.runtime.remember
import androidx.compose.ui.graphics.Color
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.navigation.navArgument
import com.example.mypokedex.presentation.Screen
import com.example.mypokedex.presentation.pokemon_details.PokemonDetailsScreen
import com.example.mypokedex.presentation.pokemon_list.PokemonListScreen
import com.example.mypokedex.ui.theme.MyPokedexTheme
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            MyPokedexTheme {
                val navController = rememberNavController()
                NavHost(
                    navController = navController,
                    startDestination = Screen.PokemonListScreen.route
                ) {
                    composable(route = Screen.PokemonListScreen.route) {
                        PokemonListScreen(navController = navController)
                    }
                    composable(
                        Screen.PokemonDetailsScreen.route + "/{dominantColor}/{pokemonName}",
                        arguments = listOf(
                            navArgument("dominantColor") {
                                type = NavType.IntType
                            },
                            navArgument("pokemonName") {
                                type = NavType.StringType
                            }
                        )
                    ) {
                        val dominantColor = remember {
                            val color = it.arguments?.getInt("dominantColor")
                            color?.let {
                                Color(it)
                            } ?: Color.White
                        }
                        val pokemonName = remember {
                            it.arguments?.getString("pokemonName")
                        }

                        PokemonDetailsScreen(
                            dominantColor = dominantColor,
                            pokemonName = pokemonName ?: "No name",
                            navController = navController
                        )
                    }
                }
            }
        }
    }
}