package com.example.rickandmortyapp.model

import android.os.Parcelable
import com.squareup.moshi.Json
import kotlinx.parcelize.Parcelize

@Parcelize
data class Character(
    @Json(name = "image")
    val image: String,
    @Json(name = "name")
    val name: String,
    @Json(name = "status")
    val status: String,
    @Json(name = "species")
    val species: String,
    @Json(name = "gender")
    val gender: String,



): Parcelable


@Parcelize
data class CharacterResponse(@Json(name = "results")
                         val result :List<Character>):Parcelable