package com.axell.marvelcharacters.data.model

import com.squareup.moshi.Json
import com.squareup.moshi.JsonClass

@JsonClass(generateAdapter = true)
data class Series(
    var available: String = "",
    var collectionURI: String = "",
    @field:Json(name = "items")
    var serieList: List<Serie> = listOf(),
    var returned: String = ""
)