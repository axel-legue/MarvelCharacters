package com.axell.marvelcharacters.features.characters.entity

import com.squareup.moshi.JsonClass

@JsonClass(generateAdapter = true)
data class CharacterWrapperEntity(
    val attributionHTML: String,
    val attributionText: String,
    val code: String,
    val copyright: String,
    val data: DataEntity,
    val etag: String,
    val status: String
)