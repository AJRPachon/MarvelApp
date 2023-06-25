package es.ajrpachon.comiclist.domain

import es.ajrpachon.data.model.charactercomic.CharacterComicBo
import es.ajrpachon.data.repository.charactercomic.CharacterComicRepository
import es.ajrpachon.data.repository.util.AsyncResult
import kotlinx.coroutines.flow.Flow

interface GetCharacterComicListUseCase {

    suspend operator fun invoke(id: Long): Flow<AsyncResult<List<CharacterComicBo>>>
}

class GetCharacterComicListUseCaseImpl(
    private val repository: CharacterComicRepository
) : GetCharacterComicListUseCase {
    override suspend fun invoke(id: Long): Flow<AsyncResult<List<CharacterComicBo>>> {
        return repository.getCharacterComicList(id).flow()
    }

}