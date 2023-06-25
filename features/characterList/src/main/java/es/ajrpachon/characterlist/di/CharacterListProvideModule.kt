package es.ajrpachon.characterlist.di

import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ViewModelComponent
import es.ajrpachon.characterlist.domain.GetCharacterUseCase
import es.ajrpachon.characterlist.domain.GetCharacterUseCaseImpl
import es.ajrpachon.data.repository.characters.CharacterRepository

@Module
@InstallIn(ViewModelComponent::class)
object CharacterListProvideModule {

    @Provides
    fun getCharacterListUseCaseImpl(repository: CharacterRepository) =
        GetCharacterUseCaseImpl(repository) as GetCharacterUseCase

}