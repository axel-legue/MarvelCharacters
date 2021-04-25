package com.axell.marvelcharacters.data.model

import com.squareup.moshi.JsonClass

@JsonClass(generateAdapter = true)
data class Url(
    var type: String = "",
    var url: String = ""
)
