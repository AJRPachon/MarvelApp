package es.ajrpachon.comiclist.domain

import es.ajrpachon.data.model.common.CommonBaseBo
import es.ajrpachon.data.repository.charactercomic.CharacterComicRepository
import es.ajrpachon.data.repository.util.AsyncResult
import kotlinx.coroutines.flow.Flow

interface GetCharacterComicListUseCase {

    suspend operator fun invoke(id: Long): Flow<AsyncResult<List<CommonBaseBo>>>
}

class GetCharacterComicListUseCaseImpl(
    private val repository: CharacterComicRepository
) : GetCharacterComicListUseCase {
    override suspend fun invoke(id: Long): Flow<AsyncResult<List<CommonBaseBo>>> {
        return repository.getCharacterComicList(id).flow()
    }

}