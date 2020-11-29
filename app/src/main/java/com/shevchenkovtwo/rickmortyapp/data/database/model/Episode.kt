package com.shevchenkovtwo.rickmortyapp.data.database.model

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import com.squareup.moshi.Json


@Entity(tableName = "episodes")
data class Episode(
    @Json(name = "id")
    @PrimaryKey
    val id: Int,

    @Json(name = "name")
    @ColumnInfo(name = "name")
    val name: String,

    @Json(name = "air_date")
    @ColumnInfo(name = "air_date")
    val airDate: String,

    @Json(name = "episode")
    @ColumnInfo(name = "episode_code")
    val code: String,

    @Json(name = "created")
    @ColumnInfo(name = "created_date")
    val created: String
)