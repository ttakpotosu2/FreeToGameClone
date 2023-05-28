package com.example.freetogameclone.data.local

import androidx.room.Database
import androidx.room.RoomDatabase
import androidx.room.TypeConverters
import com.example.freetogameclone.data.model.Converter
import com.example.freetogameclone.domain.GamesEntity
import com.example.freetogameclone.domain.GamesRemoteKeys

@Database(
    entities = [
        GamesEntity::class,
        GamesRemoteKeys::class
    ],
    version = 1,
    exportSchema = false
)
@TypeConverters(Converter::class)
abstract class GamesDatabase: RoomDatabase() {
    abstract fun gamesDao(): GamesDao
    abstract fun gamesRemoteKeysDao(): GamesRemoteKeysDao
}