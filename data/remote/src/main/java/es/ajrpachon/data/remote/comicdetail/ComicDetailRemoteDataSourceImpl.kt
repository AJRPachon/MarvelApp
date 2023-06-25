package es.ajrpachon.data.remote.comicdetail

import es.ajrpachon.data.datasource.comiddetail.ComicDetailRemoteDataSource
import es.ajrpachon.data.model.common.CommonBaseBo
import es.ajrpachon.data.remote.characters.toBo

class ComicDetailRemoteDataSourceImpl(
    private val comicDetailWs : ComicDetailWs
) : ComicDetailRemoteDataSource {
    override suspend fun getComicDetail(id: Long): CommonBaseBo {
        return comicDetailWs.getComicDetail(
            id,
            1000,
            "2f157ac459478657bb0560218058a69a",
            "54a367295082b8973cf9784bc3b7ed69"
        ).data.results.map { it.toBo() }.first()
    }
}