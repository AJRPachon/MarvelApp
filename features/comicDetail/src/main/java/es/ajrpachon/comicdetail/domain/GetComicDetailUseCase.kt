package es.ajrpachon.comicdetail.domain

import es.ajrpachon.data.model.common.CommonBaseBo
import es.ajrpachon.data.repository.comicdetail.ComicDetailRepository
import es.ajrpachon.data.repository.util.AsyncResult
import kotlinx.coroutines.flow.Flow

interface GetComicDetailUseCase {

    suspend operator fun invoke(comicId: Long): Flow<AsyncResult<CommonBaseBo>>
}

class GetComicDetailUseCaseImpl(
    private val repository: ComicDetailRepository
) : GetComicDetailUseCase {
    override suspend fun invoke(comicId: Long): Flow<AsyncResult<CommonBaseBo>> {
        return repository.getComicDetail(comicId).flow()
    }

}