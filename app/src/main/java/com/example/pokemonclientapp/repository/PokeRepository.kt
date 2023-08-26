package com.example.pokemonclientapp.repository

import android.util.Log
import com.example.pokemonclientapp.network.PokeApi
import com.example.pokemonclientapp.network.model.PokemonInfoResponse
import com.example.pokemonclientapp.network.model.PokemonsInfoResponse
import com.squareup.moshi.Moshi
import com.squareup.moshi.kotlin.reflect.KotlinJsonAdapterFactory
import okhttp3.OkHttpClient
import retrofit2.Retrofit
import retrofit2.converter.moshi.MoshiConverterFactory

class PokeRepository {
    companion object {
        val pokeApi = Retrofit.Builder()
            .baseUrl(PokeApi.BASE_URL)
            .client(OkHttpClient())
            .addConverterFactory(
                MoshiConverterFactory.create(
                    Moshi.Builder().add(
                        KotlinJsonAdapterFactory()
                    ).build()
                )
            )
            .build()
            .create(PokeApi::class.java)
    }

    suspend fun getPokemonInfo(id: String): PokemonInfoResponse? {
        return pokeApi.getPokemonInfo(id).body()
    }

    suspend fun getPokemonsInfo(): PokemonsInfoResponse? {
        return pokeApi.getPokemonsInfo().body()
    }
}