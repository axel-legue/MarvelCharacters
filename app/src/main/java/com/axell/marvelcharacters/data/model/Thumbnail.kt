package com.axell.marvelcharacters.data.model

import com.squareup.moshi.JsonClass

@JsonClass(generateAdapter = true)
data class Thumbnail(
    var extension: String = "",
    var path: String = ""
)
