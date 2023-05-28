package com.example.freetogameclone.data.model

import kotlinx.serialization.Serializable

@Serializable
data class MinimumSystemRequirements(
    val os: String?,
    val processor: String?,
    val memory: String?,
    val graphics: String?,
    val storage: String?
)
