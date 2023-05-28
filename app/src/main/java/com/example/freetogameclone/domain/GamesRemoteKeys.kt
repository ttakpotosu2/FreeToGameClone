package com.example.freetogameclone.domain

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "games_remote_keys_table")
data class GamesRemoteKeys(
    @PrimaryKey(autoGenerate = false)
    val id: Int,
    val prev: Int?,
    val next: Int?
)

