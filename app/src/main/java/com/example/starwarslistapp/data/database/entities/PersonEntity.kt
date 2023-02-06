package com.example.starwarslistapp.data.database.entities

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import com.example.starwarslistapp.domain.model.PersonItem

@Entity(tableName = "person_table")
data class PersonEntity(
    @PrimaryKey(autoGenerate = true) @ColumnInfo(name = "id") val id: Int = 0,
    @ColumnInfo(name = "name") val name: String,
    @ColumnInfo(name = "birthYear") val birthYear: String,
    @ColumnInfo(name = "eyeColor") val eyeColor: String,
    @ColumnInfo(name = "gender") val gender: String,
    @ColumnInfo(name = "hairColor") val hairColor: String,
    @ColumnInfo(name = "favorite") var favorite: Boolean = false
)

fun PersonItem.toDatabase() = PersonEntity(
    name = name,
    birthYear = birthYear,
    eyeColor = eyeColor,
    gender = gender,
    hairColor = hairColor,
    favorite = favorite
)
