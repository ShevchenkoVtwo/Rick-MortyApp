package com.shevchenkovtwo.rickmortyapp.data.database.dao

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.Query
import com.shevchenkovtwo.rickmortyapp.data.database.model.Character


@Dao
interface CharactersDao {
    @Query("SELECT*FROM characters")
    fun getAllCharactersCards(): List<Character>

    @Query("SELECT*FROM characters")
    fun deleteAllSavedCharactersCards(characters: List<Character>)

    @Insert
    fun saveCharacterCard(vararg character: Character)

    @Delete
    fun delete(character: Character)
}