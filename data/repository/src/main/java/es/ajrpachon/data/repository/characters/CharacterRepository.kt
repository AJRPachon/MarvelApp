package es.ajrpachon.data.repository.characters

import es.ajrpachon.data.datasource.characters.CharacterRemoteDataSource
import es.ajrpachon.data.model.character.CharacterBo
import es.ajrpachon.data.repository.util.AppDispatchers
import es.ajrpachon.data.repository.util.RemoteResponse
import es.ajrpachon.data.repository.util.RepositoryResponse

interface CharacterRepository {

    suspend fun getCharacter(id: Long) : RepositoryResponse<CharacterBo>
}

internal class CharacterRepositoryImpl(
    private val remote: CharacterRemoteDataSource,
    private val appDispatcher: AppDispatchers
) : CharacterRepository {

    override suspend fun getCharacter(id: Long): RepositoryResponse<CharacterBo> {
        return object: RemoteResponse<CharacterBo>(appDispatcher) {
            override suspend fun requestRemoteCall(): CharacterBo {
                return  remote.getCharacter(id)
            }
        }.build()
    }
}