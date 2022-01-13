package com.example.mypokedex.presentation.pokemon_details

import androidx.lifecycle.ViewModel
import com.example.mypokedex.data.remote.dto.Pokemon
import com.example.mypokedex.domain.repository.PokemonRepository
import com.example.mypokedex.util.Resource
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class PokemonDetailsViewModel @Inject constructor(
    private val repository: PokemonRepository
): ViewModel() {

    suspend fun getPokemonByName(pokemonName: String): Resource<Pokemon> {
        return repository.getPokemonByName(pokemonName.lowercase())
    }

}