package com.axell.marvelcharacters.features.characters.entity

import com.squareup.moshi.JsonClass

@JsonClass(generateAdapter = true)
data class StoriesEntity(
    val available: String,
    val collectionURI: String,
    val items: List<EventSummaryEntity>,
    val returned: String
)