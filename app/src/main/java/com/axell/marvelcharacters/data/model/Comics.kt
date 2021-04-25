package com.axell.marvelcharacters.data.model

import com.squareup.moshi.Json
import com.squareup.moshi.JsonClass

@JsonClass(generateAdapter = true)
data class Comics(
    var available: String = "",
    var collectionURI: String = "",
    @field:Json(name = "items")
    var comicList: List<Comic> = listOf(),
    var returned: String = ""
)