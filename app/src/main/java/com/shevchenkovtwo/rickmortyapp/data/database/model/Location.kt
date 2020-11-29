package com.shevchenkovtwo.rickmortyapp.data.database.model

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import com.squareup.moshi.Json


@Entity(tableName = "locations")
data class Location(
    @Json(name = "id")
    @PrimaryKey
    val id: Int,

    @Json(name = "name")
    @ColumnInfo(name="name")
    val name: String,

    @Json(name = "type")
    @ColumnInfo(name="type")
    val type: String,

    @Json(name = "dimension")
    @ColumnInfo(name="dimension")
    val dimension: String,

    @Json(name = "created")
    @ColumnInfo(name="created_date")
    val created: String
)