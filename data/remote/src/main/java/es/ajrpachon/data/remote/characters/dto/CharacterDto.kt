package es.ajrpachon.data.remote.characters.dto

import com.squareup.moshi.Json
import com.squareup.moshi.JsonClass

@JsonClass(generateAdapter = true)
data class CharacterDto(
    @Json(name = "id") val id: Int?,
    @Json(name = "name") val name : String?,
    @Json(name = "thumbnail") val thumbnail: CharacterImageDto
)