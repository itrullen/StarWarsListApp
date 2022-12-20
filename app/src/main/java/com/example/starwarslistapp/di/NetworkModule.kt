package com.example.starwarslistapp.di

import com.example.starwarslistapp.data.network.StarWarsApi
import io.ktor.client.*
import io.ktor.client.engine.okhttp.*
import io.ktor.client.plugins.*
import io.ktor.client.plugins.contentnegotiation.*
import io.ktor.serialization.kotlinx.json.*
import kotlinx.serialization.json.Json
import org.koin.core.qualifier.named
import org.koin.dsl.module

private const val STAR_WARS_API_URL = "https://swapi.dev/api/"

val networkModule = module {
    single(named("StarWarsApi")) {
        provideHttpClient(apiUrl = STAR_WARS_API_URL)
    }
    single { StarWarsApi(client = get(named("StarWarsApi"))) }
}

fun provideHttpClient(apiUrl: String) =
    HttpClient(OkHttp) {

        expectSuccess = true

        defaultRequest {
            url(apiUrl)
        }

        install(ContentNegotiation) {
            json(Json {
                prettyPrint = true
                isLenient = true
                ignoreUnknownKeys = true
            })
        }

    }