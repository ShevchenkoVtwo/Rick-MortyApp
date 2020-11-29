package com.shevchenkovtwo.rickmortyapp.data.database

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import com.shevchenkovtwo.rickmortyapp.data.database.dao.CharactersDao
import com.shevchenkovtwo.rickmortyapp.data.database.dao.EpisodesDao
import com.shevchenkovtwo.rickmortyapp.data.database.dao.LocationsDao
import com.shevchenkovtwo.rickmortyapp.data.database.model.Character
import com.shevchenkovtwo.rickmortyapp.data.database.model.Episode
import com.shevchenkovtwo.rickmortyapp.data.database.model.Location


@Database(entities = [Character::class, Episode::class, Location::class], version = 1)
abstract class AppDatabase : RoomDatabase() {
    abstract fun charactersDao(): CharactersDao

    abstract fun episodesDao(): EpisodesDao

    abstract fun locationsDao(): LocationsDao

    //Create instance of db
    companion object {
        private var instance: AppDatabase? = null
        private val LOCK = Any()

        operator fun invoke(context: Context) = instance ?: synchronized(LOCK) {
            instance ?: createDatabase(context).also { instance = it }
        }

        private fun createDatabase(context: Context) =
            Room.databaseBuilder(
                context.applicationContext,
                AppDatabase::class.java, "app_database"
            ).build()
    }
}