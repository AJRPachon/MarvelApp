package es.ajrpachon.data.repository.di

import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import es.ajrpachon.data.datasource.charactercomic.CharacterComicRemoteDataSource
import es.ajrpachon.data.datasource.characters.CharacterRemoteDataSource
import es.ajrpachon.data.datasource.comiddetail.ComicDetailRemoteDataSource
import es.ajrpachon.data.repository.charactercomic.CharacterComicRepository
import es.ajrpachon.data.repository.charactercomic.CharacterComicRepositoryImpl
import es.ajrpachon.data.repository.characters.CharacterRepository
import es.ajrpachon.data.repository.characters.CharacterRepositoryImpl
import es.ajrpachon.data.repository.comicdetail.ComicDetailRepository
import es.ajrpachon.data.repository.comicdetail.ComicDetailRepositoryImpl
import es.ajrpachon.data.repository.util.AppDispatchers
import kotlinx.coroutines.Dispatchers

@Module
@InstallIn(SingletonComponent::class)
object RepositoryModule {

    @Provides
    fun appDispatchersProvider() =
        AppDispatchers(Dispatchers.Main, Dispatchers.Default, Dispatchers.IO)

    @Provides
    fun charactersRepository(
        remote: CharacterRemoteDataSource,
        appdispatchers: AppDispatchers
    ) = CharacterRepositoryImpl(
        remote,
        appdispatchers
    ) as CharacterRepository

    @Provides
    fun characterComicRepository(
        remote: CharacterComicRemoteDataSource,
        appdispatchers: AppDispatchers
    ) = CharacterComicRepositoryImpl(
        remote,
        appdispatchers
    ) as CharacterComicRepository

    @Provides
    fun comicDetailRepository(
        remote: ComicDetailRemoteDataSource,
        appdispatchers: AppDispatchers
    ) = ComicDetailRepositoryImpl(
        remote,
        appdispatchers
    ) as ComicDetailRepository
}
