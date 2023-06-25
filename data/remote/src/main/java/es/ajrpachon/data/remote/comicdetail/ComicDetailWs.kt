package es.ajrpachon.data.remote.comicdetail

import es.ajrpachon.data.remote.root.dto.RootDto
import retrofit2.http.GET
import retrofit2.http.Path
import retrofit2.http.Query

interface ComicDetailWs {

    @GET("comics/{id}")
    suspend fun getComicDetail(
        @Path("id") id : Long,
        @Query("ts") ts : Long,
        @Query("apikey") apiKey: String,
        @Query("hash") hash: String
    ): RootDto
}