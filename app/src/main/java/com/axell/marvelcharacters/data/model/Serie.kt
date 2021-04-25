package com.axell.marvelcharacters.data.model

import com.squareup.moshi.JsonClass

@JsonClass(generateAdapter = true)
data class Serie(
    var name: String = "",
    var resourceURI: String = ""
)