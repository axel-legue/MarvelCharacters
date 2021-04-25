package com.axell.marvelcharacters.data.model

import com.squareup.moshi.JsonClass

@JsonClass(generateAdapter = true)
data class Character(
    var comics: Comics = Comics(),
    var description: String = "",
    var events: Events = Events(),
    var id: String = "",
    var modified: String = "",
    var name: String = "",
    var resourceURI: String = "",
    var series: Series = Series(),
    var stories: Stories = Stories(),
    var thumbnail: Thumbnail = Thumbnail(),
    var urls: List<Url> = listOf()
)