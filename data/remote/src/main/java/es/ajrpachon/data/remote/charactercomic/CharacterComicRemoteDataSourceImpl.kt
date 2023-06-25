package es.ajrpachon.data.remote.charactercomic

import es.ajrpachon.data.datasource.charactercomic.CharacterComicRemoteDataSource
import es.ajrpachon.data.model.charactercomic.CharacterComicBo
import es.ajrpachon.data.remote.characters.toComicBo

class CharacterComicRemoteDataSourceImpl(
    private val characterComicWs : CharacterComicWs
) : CharacterComicRemoteDataSource {
    override suspend fun getCharacterComicList(id: Long): List<CharacterComicBo> {
        return characterComicWs.getCharacterComicList(
            id,
            1000,
            "2f157ac459478657bb0560218058a69a",
            "54a367295082b8973cf9784bc3b7ed69"
        ).data.results.map { it.toComicBo() }
    }
}
