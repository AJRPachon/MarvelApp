package es.ajrpachon.data.remote.characters

import es.ajrpachon.data.model.common.CommonBaseBo
import es.ajrpachon.data.model.common.CommonBaseImageBo
import es.ajrpachon.data.remote.common.dto.CommonBaseDto
import es.ajrpachon.data.remote.common.dto.CommonBaseImageDto

internal fun CommonBaseDto.toBo() =
    CommonBaseBo(
        id = id,
        title = title,
        description = description,
        image = thumbnail.toBo()
    )


internal fun CommonBaseImageDto.toBo() =
    CommonBaseImageBo(
        path = path,
        extension = extension
    )