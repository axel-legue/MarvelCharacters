package com.axell.marvelcharacters.data.model

import com.squareup.moshi.Json
import com.squareup.moshi.JsonClass

@JsonClass(generateAdapter = true)
data class Stories(
    var available: String = "",
    var collectionURI: String = "",
    @field:Json(name = "items")
    var storyList: List<Story> = listOf(),
    var returned: String = ""
)