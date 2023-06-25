package es.ajrpachon.comicdetail.di

import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ViewModelComponent
import es.ajrpachon.comicdetail.domain.GetComicDetailUseCase
import es.ajrpachon.comicdetail.domain.GetComicDetailUseCaseImpl
import es.ajrpachon.data.repository.comicdetail.ComicDetailRepository

@Module
@InstallIn(ViewModelComponent::class)
object ComicDetailProvideModule {

    @Provides
    fun provideComicDetailUseCaseImpl(repository: ComicDetailRepository) =
        GetComicDetailUseCaseImpl(repository) as GetComicDetailUseCase
}