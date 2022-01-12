package com.example.mypokedex.di

import com.example.mypokedex.data.remote.PokemonAPI
import com.example.mypokedex.data.repository.PokemonRepositoryImpl
import com.example.mypokedex.domain.repository.PokemonRepository
import com.example.mypokedex.util.Constants
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object AppModule {

    @Provides
    @Singleton
    fun providePokemonAPI(): PokemonAPI {
        return Retrofit.Builder()
            .addConverterFactory(GsonConverterFactory.create())
            .baseUrl(Constants.BASE_URL)
            .build()
            .create(PokemonAPI::class.java)
    }

    @Provides
    @Singleton
    fun providePokemonRepository(api: PokemonAPI): PokemonRepository {
        return PokemonRepositoryImpl(api)
    }


}