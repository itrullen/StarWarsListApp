package com.example.starwarslistapp.di

import android.content.Context
import androidx.room.Room
import com.example.starwarslistapp.data.database.StarWarsDataBase
import com.example.starwarslistapp.data.database.dao.PersonDAO
import org.koin.android.ext.koin.androidApplication
import org.koin.android.ext.koin.androidContext
import org.koin.core.qualifier.named
import org.koin.dsl.module


const val STAR_WARS_DATABASE_NAME = "star_wars_database"

val roomModule = module {
    single(named("roomDatabase")) {
        provideRoom(androidApplication())
    }

    single(named("personDAO")) {
        provideStarWarsDao(provideRoom(androidApplication()))
    }
}

fun provideRoom(context: Context): StarWarsDataBase = Room.databaseBuilder(
    context,
    StarWarsDataBase::class.java,
    STAR_WARS_DATABASE_NAME
).build()

fun provideStarWarsDao(database: StarWarsDataBase): PersonDAO = database.getPersonDAO()