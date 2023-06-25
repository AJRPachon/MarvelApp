package es.ajrpachon.data.remote.characters.dto

import com.squareup.moshi.Json
import com.squareup.moshi.JsonClass

@JsonClass(generateAdapter = true)
data class CharacterImageDto(
    @Json(name = "path") val path: String?,
    @Json(name = "extension") val extension: String?
)
