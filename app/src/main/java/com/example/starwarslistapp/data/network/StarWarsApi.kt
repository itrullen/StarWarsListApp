package com.example.starwarslistapp.data.network

import com.example.starwarslistapp.data.model.PersonDTO
import com.example.starwarslistapp.data.model.StarWarsElementDTO
import io.ktor.client.*
import io.ktor.client.call.*
import io.ktor.client.request.*

class StarWarsApi(private val client: HttpClient) {
    suspend fun getPeople(): StarWarsElementDTO<PersonDTO> = client.get("people").body()
}