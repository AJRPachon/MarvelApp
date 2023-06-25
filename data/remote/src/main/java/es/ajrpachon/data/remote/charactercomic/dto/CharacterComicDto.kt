package es.ajrpachon.data.remote.charactercomic.dto

import com.squareup.moshi.Json
import com.squareup.moshi.JsonClass
import es.ajrpachon.data.remote.characters.dto.CharacterImageDto

@JsonClass(generateAdapter = true)
data class CharacterComicDto(
    @Json(name = "id") val id: Int?,
    @Json(name = "thumbnail") val thumbnail: CharacterImageDto
)
