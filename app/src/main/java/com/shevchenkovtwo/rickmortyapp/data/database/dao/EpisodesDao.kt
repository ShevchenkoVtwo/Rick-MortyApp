package com.shevchenkovtwo.rickmortyapp.data.database.dao

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.Query
import com.shevchenkovtwo.rickmortyapp.data.database.model.Episode


@Dao
interface EpisodesDao {
    @Query("SELECT*FROM episodes")
    fun getAllCharactersCards(): List<Episode>

    @Query("SELECT*FROM episodes")
    fun deleteAllSavedCharactersCards(episodes: List<Episode>)

    @Insert
    fun saveCharacterCard(vararg episode: Episode)

    @Delete
    fun delete(episode: Episode)
}
