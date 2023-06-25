package es.ajrpachon.characterlist.domain

import es.ajrpachon.data.model.common.CommonBaseBo
import es.ajrpachon.data.repository.characters.CharacterRepository
import es.ajrpachon.data.repository.util.AsyncResult
import kotlinx.coroutines.flow.Flow

interface GetCharacterUseCase {

    suspend operator fun invoke(id: Long) : Flow<AsyncResult<CommonBaseBo>>
}

class GetCharacterUseCaseImpl(
    private val repository: CharacterRepository
) : GetCharacterUseCase {
    override suspend fun invoke(id: Long): Flow<AsyncResult<CommonBaseBo>> {
        return repository.getCharacter(id).flow()
    }

}