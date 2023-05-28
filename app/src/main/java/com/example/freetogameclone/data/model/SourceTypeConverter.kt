package com.example.freetogameclone.data.model

import androidx.room.TypeConverter
import kotlinx.serialization.decodeFromString
import kotlinx.serialization.encodeToString
import kotlinx.serialization.json.Json

class Converter {

    @TypeConverter
    fun fromMinimumSystemRequirements(source: MinimumSystemRequirements?): String{
        return Json.encodeToString(source)
    }

    @TypeConverter
    fun toMinimumSystemRequirements(source: String): MinimumSystemRequirements?{
        return  Json.decodeFromString(source)
    }

    @TypeConverter
    fun fromScreenshots(source: List<Screenshots>): String {
        return source.toString()
    }

    @TypeConverter
    fun toScreenshots(source: String): List<Screenshots> {
        return source.let { Json.decodeFromString(it) }
    }
}