package es.ajrpachon.data.remote.characters

import es.ajrpachon.data.model.character.CharacterBo
import es.ajrpachon.data.model.character.CharacterImageBo
import es.ajrpachon.data.model.charactercomic.CharacterComicBo
import es.ajrpachon.data.remote.characters.dto.CharacterDto
import es.ajrpachon.data.remote.characters.dto.CharacterImageDto
import es.ajrpachon.data.remote.root.dto.RootDto

internal fun CharacterDto.toBo() =
    CharacterBo(
        id = id,
        name = name,
        image = thumbnail.toBo()
    )

internal fun CharacterDto.toComicBo() =
    CharacterComicBo(
        id = id,
        image = thumbnail.toBo()
    )

internal fun CharacterImageDto.toBo() =
    CharacterImageBo(
        path = path,
        extension = extension
    )