package com.example.mypokedex.data.repository

import com.example.mypokedex.data.remote.PokemonAPI
import com.example.mypokedex.data.remote.dto.Pokemon
import com.example.mypokedex.data.remote.dto.PokemonList
import com.example.mypokedex.domain.repository.PokemonRepository
import com.example.mypokedex.util.Resource
import java.lang.Exception
import javax.inject.Inject

class PokemonRepositoryImpl @Inject constructor(
    private val api: PokemonAPI
) : PokemonRepository {

    override suspend fun getPokemonList(limit: Int, offset: Int): Resource<PokemonList> {
        val response = try {
            api.getPokemonList(limit, offset)
        } catch (e: Exception) {
            return Resource.Error(e.localizedMessage ?: "An unexpected error occurred")
        }

        return Resource.Success(response)
    }

    override suspend fun getPokemonByName(pokemonName: String): Resource<Pokemon> {
        val response = try {
            api.getPokemonByName(pokemonName)
        } catch (e: Exception) {
            return Resource.Error(e.localizedMessage ?: "An unexpected error occurred")
        }

        return Resource.Success(response)
    }
}