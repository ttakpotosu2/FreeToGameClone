package com.example.freetogameclone.domain

import androidx.room.Entity
import androidx.room.PrimaryKey
import com.example.freetogameclone.data.model.MinimumSystemRequirements
import com.example.freetogameclone.data.model.Screenshots

@Entity(tableName = "games_entity_table")
data class GamesEntity(
    @PrimaryKey
    val id: Int,
    val title: String,
    val thumbnail: String,
    val shortDescription: String,
    val gameLink: String,
    val genre: String,
    val platform: String,
    val publisher: String,
    val developer: String,
    val releaseDate: String,
    val profile: String,
    val description: String,
    val minimumSystemRequirements: MinimumSystemRequirements?,
    val screenShots: List<Screenshots>,
    val status: String
)