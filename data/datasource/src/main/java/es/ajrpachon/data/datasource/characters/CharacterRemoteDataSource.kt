package es.ajrpachon.data.datasource.characters

import es.ajrpachon.data.model.character.CharacterBo

interface CharacterRemoteDataSource {

    suspend fun getCharacter(id: Long): CharacterBo
}