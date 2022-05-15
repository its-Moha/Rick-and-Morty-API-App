package com.example.rickandmortyapp.repository


import com.example.rickandmortyapp.network.api


class Repository (private val apiService: api){
   suspend fun getCharacters(page: String) = apiService.getMyData(page)
}