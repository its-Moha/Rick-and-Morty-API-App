package com.example.rickandmortyapp.network

import com.example.rickandmortyapp.model.CharacterResponse
import com.squareup.moshi.Moshi
import com.squareup.moshi.kotlin.reflect.KotlinJsonAdapterFactory
import retrofit2.Call
import retrofit2.Retrofit
import retrofit2.converter.moshi.MoshiConverterFactory
import retrofit2.http.GET
import retrofit2.http.Query


object RetrofitInstance {


    var moshi: Moshi = Moshi.Builder()
    .add(KotlinJsonAdapterFactory())
    .build()

    val retrofit by lazy {
        Retrofit.Builder()
            .baseUrl("https://rickandmortyapi.com/api/")
            .addConverterFactory(MoshiConverterFactory.create(moshi))
            .build()

    }

    val api by lazy {
       retrofit.create(api::class.java)
    }
}
