package com.axell.marvelcharacters.data.model

import com.squareup.moshi.Json
import com.squareup.moshi.JsonClass

@JsonClass(generateAdapter = true)
data class CharacterDataWrapper(
    var attributionHTML: String = "",
    var attributionText: String = "",
    var code: String = "",
    var copyright: String = "",
    @field:Json(name = "data")
    var characterDataContainer: CharacterDataContainer = CharacterDataContainer(),
    var etag: String = "",
    var status: String = ""
)
