package es.ajrpachon.comiclist.di

import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ViewModelComponent
import es.ajrpachon.comiclist.domain.GetCharacterComicListUseCase
import es.ajrpachon.comiclist.domain.GetCharacterComicListUseCaseImpl
import es.ajrpachon.data.repository.charactercomic.CharacterComicRepository

@Module
@InstallIn(ViewModelComponent::class)
object CharacterComicProvideModule {

    @Provides
    fun getCharacterComicUseCaseImpl(repository: CharacterComicRepository) =
        GetCharacterComicListUseCaseImpl(repository) as GetCharacterComicListUseCase
}