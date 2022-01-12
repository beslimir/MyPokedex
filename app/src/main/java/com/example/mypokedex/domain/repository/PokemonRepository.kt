package com.example.mypokedex.domain.repository

import com.example.mypokedex.data.remote.dto.Pokemon
import com.example.mypokedex.data.remote.dto.PokemonList
import com.example.mypokedex.util.Resource

interface PokemonRepository {

    suspend fun getPokemonList(limit: Int, offset: Int): Resource<PokemonList>

    suspend fun getPokemonByName(pokemonName: String): Resource<Pokemon>

}