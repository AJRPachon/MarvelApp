package es.ajrpachon.data.datasource.charactercomic

import es.ajrpachon.data.model.charactercomic.CharacterComicBo

interface CharacterComicRemoteDataSource {

    suspend fun getCharacterComicList(id: Long) : List<CharacterComicBo>
}