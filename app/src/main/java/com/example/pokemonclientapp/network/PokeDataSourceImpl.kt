package com.example.pokemonclientapp.network

import com.example.pokemonclientapp.network.model.PokemonInfoResponse
import com.example.pokemonclientapp.network.model.PokemonsInfoResponse
import com.squareup.moshi.Moshi
import com.squareup.moshi.kotlin.reflect.KotlinJsonAdapterFactory
import okhttp3.OkHttpClient
import retrofit2.Retrofit
import retrofit2.converter.moshi.MoshiConverterFactory

open class PokeDataSourceImpl: PokeDataSource {
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
    override suspend fun getPokemonInfo(name: String): PokemonInfoResponse {
        val response = pokeApi.getPokemonInfo(name)
        if (response.isSuccessful) {
            return requireNotNull(response.body())
        } else {
            throw HttpException()
        }
    }

    override suspend fun getPokemonsInfo(): PokemonsInfoResponse {
        val response = pokeApi.getPokemonsInfo()
        if (response.isSuccessful) {
            return requireNotNull(response.body())
        } else {
            throw HttpException()
        }
    }
}

class HttpException: Throwable()