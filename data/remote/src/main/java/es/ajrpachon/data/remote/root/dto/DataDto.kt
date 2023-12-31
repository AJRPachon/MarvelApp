package es.ajrpachon.data.remote.root.dto

import com.squareup.moshi.Json
import com.squareup.moshi.JsonClass
import es.ajrpachon.data.remote.common.dto.CommonBaseDto

@JsonClass(generateAdapter = true)
data class DataDto(
    @Json(name = "results") val results: List<CommonBaseDto>,
)