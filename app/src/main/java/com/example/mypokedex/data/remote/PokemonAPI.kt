package com.example.mypokedex.data.remote

import com.example.mypokedex.data.remote.dto.Pokemon
import com.example.mypokedex.data.remote.dto.PokemonList
import retrofit2.http.GET
import retrofit2.http.Path
import retrofit2.http.Query

interface PokemonAPI {

    @GET("pokemon")
    suspend fun getPokemonList(
        @Query("limit") limit: Int,
        @Query("offset") offset: Int
    ): PokemonList

    @GET("pokemon/{name}")
    suspend fun getPokemonByName(
        @Path("name") pokemonName: String
    ): Pokemon

}