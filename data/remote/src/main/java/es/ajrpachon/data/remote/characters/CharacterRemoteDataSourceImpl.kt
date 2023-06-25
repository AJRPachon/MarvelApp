package es.ajrpachon.data.remote.characters

import es.ajrpachon.data.datasource.characters.CharacterRemoteDataSource
import es.ajrpachon.data.model.common.CommonBaseBo

class CharacterRemoteDataSourceImpl(
    private val charactersWs: CharactersWs
) : CharacterRemoteDataSource {

    override suspend fun getCharacter(id: Long): CommonBaseBo {
        return charactersWs.getCharacter(
            id,
            1000,
            "2f157ac459478657bb0560218058a69a",
            "54a367295082b8973cf9784bc3b7ed69"
        ).data.results.map { it.toBo() }.first()
    }

}