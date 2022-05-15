package com.example.rickandmortyapp.network

import com.example.rickandmortyapp.model.CharacterResponse
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Query


interface api {


    @GET("character")

    suspend fun getMyData(@Query("page") page: String):  CharacterResponse
}