package es.ajrpachon.characterlist.domain

import es.ajrpachon.data.model.character.CharacterBo
import es.ajrpachon.data.repository.characters.CharacterRepository
import es.ajrpachon.data.repository.util.AsyncResult
import kotlinx.coroutines.flow.Flow

interface GetCharacterUseCase {

    suspend operator fun invoke(id: Long) : Flow<AsyncResult<CharacterBo>>
}

class GetCharacterUseCaseImpl(
    private val repository: CharacterRepository
) : GetCharacterUseCase {
    override suspend fun invoke(id: Long): Flow<AsyncResult<CharacterBo>> {
        return repository.getCharacter(id).flow()
    }

}