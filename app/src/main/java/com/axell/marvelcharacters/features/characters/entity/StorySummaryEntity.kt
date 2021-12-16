package com.axell.marvelcharacters.features.characters.entity

import com.squareup.moshi.JsonClass

@JsonClass(generateAdapter = true)
data class StorySummaryEntity(
    val name: String,
    val resourceURI: String
)