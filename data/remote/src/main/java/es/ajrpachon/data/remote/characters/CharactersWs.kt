package es.ajrpachon.data.remote.characters

import es.ajrpachon.data.remote.root.dto.RootDto
import retrofit2.http.GET
import retrofit2.http.Path
import retrofit2.http.Query

interface CharactersWs {

    @GET("characters/{id}")
    suspend fun getCharacter(
        @Path("id") id : Long,
        @Query("ts") ts : Long,
        @Query("apikey") apiKey: String,
        @Query("hash") hash: String
    ): RootDto
}