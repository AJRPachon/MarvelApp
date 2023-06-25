package es.ajrpachon.data.remote.common.dto

import com.squareup.moshi.Json
import com.squareup.moshi.JsonClass

@JsonClass(generateAdapter = true)
data class CommonBaseDto(
    @Json(name = "id") val id: Int?,
    @Json(name = "title") val title: String?,
    @Json(name = "description") val description: String?,
    @Json(name = "thumbnail") val thumbnail: CommonBaseImageDto
)
