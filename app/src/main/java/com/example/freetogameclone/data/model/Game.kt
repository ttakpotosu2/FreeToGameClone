package com.example.freetogameclone.data.model

import com.example.freetogameclone.domain.GamesEntity
import com.google.gson.annotations.SerializedName
import kotlinx.serialization.Serializable

@Serializable
data class Game(
    val id: Int,
    val title: String?,
    val thumbnail: String?,
    @SerializedName("short_description")
    val shortDescription: String?,
    @SerializedName("game_url")
    val gameLink: String?,
    val genre: String?,
    val platform: String?,
    val publisher: String?,
    val developer: String?,
    @SerializedName("release_date")
    val releaseDate: String?,
    @SerializedName("freetogame_profile_url")
    val profile: String?,
    val status: String?,
    @SerializedName("screenshots")
    val screenShots: List<Screenshots>?,
    @SerializedName("minimum_system_requirements")
    val minimumSystemRequirements: MinimumSystemRequirements?,
    val description: String?,
    ){
    fun toGamesEntity(): GamesEntity{
        return GamesEntity(
            id = id,
            title = title ?: "no title",
            thumbnail = thumbnail ?: "no thumbnail",
            shortDescription = shortDescription ?: "no description",
            gameLink = gameLink ?: "no link",
            genre = genre ?: "no genre",
            platform = platform ?: "no platform",
            publisher = publisher ?: "no publisher",
            developer = developer ?: "no developer",
            releaseDate = releaseDate ?: "no release date",
            profile = profile ?: "no profile",
            description = description ?: "no description",
            minimumSystemRequirements = minimumSystemRequirements,
            screenShots = screenShots ?: emptyList(),
            status = status ?: "no status",
        )
    }
}