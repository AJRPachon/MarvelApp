package es.ajrpachon.data.remote.root.dto

import com.squareup.moshi.Json
import com.squareup.moshi.JsonClass

@JsonClass(generateAdapter = true)
data class RootDto(
    @Json(name = "data") val data: DataDto,
)