package com.axell.marvelcharacters.features.characters.entity

import com.axell.marvelcharacters.features.characters.model.Character
import com.squareup.moshi.JsonClass

@JsonClass(generateAdapter = true)
data class ResultEntity(
    val comics: ComicsEntity,
    val description: String,
    val events: EventsEntity,
    val id: Int,
    val modified: String,
    val name: String,
    val resourceURI: String,
    val series: SeriesEntity,
    val stories: StoriesEntity,
    val thumbnail: ThumbnailEntity,
    val urls: List<UrlEntity>
) {
    fun toCharacter() = Character(id, name, thumbnail.toThumbnail())
}