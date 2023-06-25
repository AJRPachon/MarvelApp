package es.ajrpachon.data.repository.comicdetail

import es.ajrpachon.data.datasource.comiddetail.ComicDetailRemoteDataSource
import es.ajrpachon.data.model.common.CommonBaseBo
import es.ajrpachon.data.repository.util.AppDispatchers
import es.ajrpachon.data.repository.util.RemoteResponse
import es.ajrpachon.data.repository.util.RepositoryResponse

interface ComicDetailRepository {

    suspend fun getComicDetail(id: Long): RepositoryResponse<CommonBaseBo>
}

internal class ComicDetailRepositoryImpl(
    private val remote : ComicDetailRemoteDataSource,
    private val appDispatchers: AppDispatchers
) : ComicDetailRepository {
    override suspend fun getComicDetail(id: Long): RepositoryResponse<CommonBaseBo> {
        return object: RemoteResponse<CommonBaseBo>(appDispatchers) {
            override suspend fun requestRemoteCall(): CommonBaseBo {
                return remote.getComicDetail(id)
            }
        }.build()
    }

}