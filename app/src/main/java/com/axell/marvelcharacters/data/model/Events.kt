package com.axell.marvelcharacters.data.model

import com.squareup.moshi.Json
import com.squareup.moshi.JsonClass

@JsonClass(generateAdapter = true)
data class Events(
    var available: String = "",
    var collectionURI: String = "",
    @field:Json(name = "items")
    var eventList: List<Event> = listOf(),
    var returned: String = ""
)
