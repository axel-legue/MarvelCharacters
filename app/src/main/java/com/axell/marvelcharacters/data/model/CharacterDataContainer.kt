package com.axell.marvelcharacters.data.model

import com.squareup.moshi.Json
import com.squareup.moshi.JsonClass

@JsonClass(generateAdapter = true)
data class CharacterDataContainer(
    var count: String = "",
    var limit: String = "",
    var offset: String = "",
    @field:Json(name = "results")
    var Characters: List<Character> = listOf(),
    var total: String = ""
)