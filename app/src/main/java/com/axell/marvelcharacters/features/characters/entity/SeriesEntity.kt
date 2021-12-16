package com.axell.marvelcharacters.features.characters.entity

import com.squareup.moshi.JsonClass

@JsonClass(generateAdapter = true)
data class SeriesEntity(
    val available: String,
    val collectionURI: String,
    val items: List<StorySummaryEntity>,
    val returned: String
)