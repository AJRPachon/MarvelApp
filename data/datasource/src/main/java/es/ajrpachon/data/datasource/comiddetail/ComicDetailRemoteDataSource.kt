package es.ajrpachon.data.datasource.comiddetail

import es.ajrpachon.data.model.common.CommonBaseBo

interface ComicDetailRemoteDataSource {

    suspend fun getComicDetail(comicId: Long): CommonBaseBo
}