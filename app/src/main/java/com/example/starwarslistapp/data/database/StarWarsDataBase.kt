package com.example.starwarslistapp.data.database

import androidx.room.Database
import androidx.room.RoomDatabase
import com.example.starwarslistapp.data.database.dao.PersonDAO
import com.example.starwarslistapp.data.database.entities.PersonEntity

@Database(
    entities = [PersonEntity::class],
    version = 1
)
abstract class StarWarsDataBase : RoomDatabase() {
    abstract fun getPersonDAO(): PersonDAO
}