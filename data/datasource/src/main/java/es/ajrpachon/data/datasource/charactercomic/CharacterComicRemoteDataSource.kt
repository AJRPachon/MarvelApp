package es.ajrpachon.data.datasource.charactercomic

import es.ajrpachon.data.model.common.CommonBaseBo

interface CharacterComicRemoteDataSource {

    suspend fun getCharacterComicList(id: Long) : List<CommonBaseBo>
}