package com.axell.marvelcharacters.features.characters.entity

import com.axell.marvelcharacters.features.characters.model.Thumbnail
import com.squareup.moshi.JsonClass

@JsonClass(generateAdapter = true)
data class ThumbnailEntity(
    val extension: String,
    val path: String
) {
    fun toThumbnail() = Thumbnail(extension, path)
}