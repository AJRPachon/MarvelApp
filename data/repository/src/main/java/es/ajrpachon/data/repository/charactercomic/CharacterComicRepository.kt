package es.ajrpachon.data.repository.charactercomic

import es.ajrpachon.data.datasource.charactercomic.CharacterComicRemoteDataSource
import es.ajrpachon.data.model.charactercomic.CharacterComicBo
import es.ajrpachon.data.repository.util.AppDispatchers
import es.ajrpachon.data.repository.util.RemoteResponse
import es.ajrpachon.data.repository.util.RepositoryResponse

interface CharacterComicRepository {
    suspend fun getCharacterComicList(id: Long): RepositoryResponse<List<CharacterComicBo>>

}

internal class CharacterComicRepositoryImpl(
    private val remote: CharacterComicRemoteDataSource,
    private val appDispatcher: AppDispatchers
) : CharacterComicRepository {

    override suspend fun getCharacterComicList(id: Long): RepositoryResponse<List<CharacterComicBo>> {
        return object : RemoteResponse<List<CharacterComicBo>>(appDispatcher) {
            override suspend fun requestRemoteCall(): List<CharacterComicBo> {
                return remote.getCharacterComicList(id)
            }
        }.build()
    }
}