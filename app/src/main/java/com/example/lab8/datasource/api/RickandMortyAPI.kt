package com.example.lab8.datasource.api

import com.example.lab8.datasource.model.ResultDto
import com.example.lab8.datasource.model.ResultResponse
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Path

interface RickandMortyAPI {
    @GET("/api/character")
    fun getRickandMorty(): Call<ResultResponse>

    @GET("/api/character/{id}")
    fun getCharacter(
        @Path("id") id: Int
    ): Call<ResultDto>
}