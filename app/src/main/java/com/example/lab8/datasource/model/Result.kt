package com.example.lab8.datasource.model

data class ResultDto(
    val id: Int,
    val name: String,
    val status: String,
    val species: String,
    val gender: String,
    val image: String,
    val origin: Origin,
    val episode: List<String>,
)