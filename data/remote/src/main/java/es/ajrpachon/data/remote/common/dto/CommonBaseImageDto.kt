package es.ajrpachon.data.remote.common.dto

import com.squareup.moshi.Json
import com.squareup.moshi.JsonClass

@JsonClass(generateAdapter = true)
data class CommonBaseImageDto(
    @Json(name = "path") val path: String?,
    @Json(name = "extension") val extension: String?
)
