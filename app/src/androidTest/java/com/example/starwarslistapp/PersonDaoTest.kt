package com.example.starwarslistapp

import androidx.room.Room
import androidx.test.core.app.ApplicationProvider
import androidx.test.filters.SmallTest
import androidx.test.runner.AndroidJUnit4
import com.example.starwarslistapp.data.database.StarWarsDataBase
import com.example.starwarslistapp.data.database.dao.PersonDAO
import com.example.starwarslistapp.data.database.entities.PersonEntity
import com.google.common.truth.Truth
import kotlinx.coroutines.*
import org.junit.After
import org.junit.Before
import org.junit.Test
import org.junit.runner.RunWith

@RunWith(AndroidJUnit4::class)
@SmallTest
class PersonDaoTest {
    private lateinit var database: StarWarsDataBase
    private lateinit var personDao: PersonDAO

    @Before
    fun setupDatabase() {
        //creates a database in RAM instead of the persistence storage
        database = Room.inMemoryDatabaseBuilder(
            ApplicationProvider.getApplicationContext(), StarWarsDataBase::class.java
        ).allowMainThreadQueries().build()

        personDao = database.getPersonDAO()
    }

    @After
    fun closeDatabase() {
        database.close()
    }


    @Test
    fun insertAllPeople_returnsTrue() = runBlocking {
        val people = listOf(
            PersonEntity(
                id = 1,
                name = "Luke Skywalker",
                birthYear = "UUDD",
                eyeColor = "blue",
                gender = "male",
                hairColor = "red",
                favorite = false
            ), PersonEntity(
                id = 2,
                name = "Dark Vather",
                birthYear = "2022",
                eyeColor = "grey",
                gender = "male",
                hairColor = "black",
                favorite = false
            )
        )
        personDao.insertAll(people)

        val result = personDao.getAllPeople()

        Truth.assertThat(result).isEqualTo(people)
    }

}