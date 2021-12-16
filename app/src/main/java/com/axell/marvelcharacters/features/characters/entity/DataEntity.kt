package com.axell.marvelcharacters.features.characters.entity

import com.squareup.moshi.JsonClass

@JsonClass(generateAdapter = true)
data class DataEntity(
    val count: String,
    val limit: String,
    val offset: String,
    val results: List<ResultEntity>,
    val total: String
)