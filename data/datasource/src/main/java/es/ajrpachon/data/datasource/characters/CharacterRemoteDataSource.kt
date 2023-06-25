package es.ajrpachon.data.datasource.characters

import es.ajrpachon.data.model.common.CommonBaseBo

interface CharacterRemoteDataSource {

    suspend fun getCharacter(id: Long): CommonBaseBo
}