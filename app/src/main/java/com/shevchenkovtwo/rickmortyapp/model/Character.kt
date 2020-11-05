package com.shevchenkovtwo.rickmortyapp.model

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import com.squareup.moshi.Json

@Entity(tableName = "characters")
data class Character(
    @Json(name = "id")
    @PrimaryKey
    val id: Int,

    @Json(name = "name")
    @ColumnInfo(name = "name")
    val name: String,

    @Json(name = "status")
    @ColumnInfo(name = "status")
    val status: String,

    @Json(name = "species")
    @ColumnInfo(name = "species")
    val species: String,

    @Json(name = "gender")
    @ColumnInfo(name = "gender")
    val gender: String,

    @Json(name = "image")
    @ColumnInfo(name = "image_url")
    val image: String,

    @Json(name = "created")
    @ColumnInfo(name = "created_date")
    val created: String
)