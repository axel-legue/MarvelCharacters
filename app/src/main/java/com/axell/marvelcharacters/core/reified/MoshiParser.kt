package com.axell.marvelcharacters.core.reified

import com.squareup.moshi.Moshi
import com.squareup.moshi.Types

inline fun <reified T> List<T>.toJsonString(): String {
    val type = Types.newParameterizedType(MutableList::class.java, T::class.java)
    val moshi = Moshi.Builder().build()
    val adapter = moshi.adapter<List<T>>(type)
    return adapter.toJson(this)
}

inline fun <reified T> String?.fromJsonStringToList(): List<T>? {
    if (this == null) return null
    val type = Types.newParameterizedType(MutableList::class.java, T::class.java)
    val moshi = Moshi.Builder().build()
    val adapter = moshi.adapter<List<T>>(type)
    return adapter.fromJson(this)
}