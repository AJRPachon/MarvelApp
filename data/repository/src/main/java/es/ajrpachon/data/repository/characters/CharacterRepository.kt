package es.ajrpachon.data.repository.characters

import es.ajrpachon.data.datasource.characters.CharacterRemoteDataSource
import es.ajrpachon.data.model.common.CommonBaseBo
import es.ajrpachon.data.repository.util.AppDispatchers
import es.ajrpachon.data.repository.util.RemoteResponse
import es.ajrpachon.data.repository.util.RepositoryResponse

interface CharacterRepository {

    suspend fun getCharacter(id: Long) : RepositoryResponse<CommonBaseBo>
}

internal class CharacterRepositoryImpl(
    private val remote: CharacterRemoteDataSource,
    private val appDispatcher: AppDispatchers
) : CharacterRepository {

    override suspend fun getCharacter(id: Long): RepositoryResponse<CommonBaseBo> {
        return object: RemoteResponse<CommonBaseBo>(appDispatcher) {
            override suspend fun requestRemoteCall(): CommonBaseBo {
                return  remote.getCharacter(id)
            }
        }.build()
    }
}