package com.shevchenkovtwo.rickmortyapp.data.database.dao

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.Query
import com.shevchenkovtwo.rickmortyapp.data.database.model.Location


@Dao
interface LocationsDao {
    @Query("SELECT*FROM locations")
    fun getAllCharactersCards(): List<Location>

    @Query("SELECT*FROM locations")
    fun deleteAllSavedCharactersCards(locations: List<Location>)

    @Insert
    fun saveCharacterCard(vararg location: Location)

    @Delete
    fun delete(location: Location)
}