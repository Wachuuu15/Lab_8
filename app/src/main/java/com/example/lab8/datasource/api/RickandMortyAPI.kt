package com.example.lab8.datasource.api


import com.example.lab8.datasource.model.AllAssetsResponse
import retrofit2.Call
import retrofit2.http.GET

interface RickandMortyAPI {
    @GET("api/character")
    fun getRickandMorty(): Call<AllAssetsResponse>
}