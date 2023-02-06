package com.example.starwarslistapp.data.database.dao

import androidx.room.*
import com.example.starwarslistapp.data.database.entities.PersonEntity

@Dao
interface PersonDAO {

    @Query("SELECT * FROM person_table")
    suspend fun getAllPeople(): List<PersonEntity>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertAll(people: List<PersonEntity>)

    @Query("DELETE FROM person_table")
    suspend fun deleteAllPeople()
}