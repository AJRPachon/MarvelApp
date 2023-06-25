package es.ajrpachon.data.remote.di

import com.squareup.moshi.Moshi
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import es.ajrpachon.data.datasource.charactercomic.CharacterComicRemoteDataSource
import es.ajrpachon.data.datasource.characters.CharacterRemoteDataSource
import es.ajrpachon.data.datasource.comiddetail.ComicDetailRemoteDataSource
import es.ajrpachon.data.remote.charactercomic.CharacterComicRemoteDataSourceImpl
import es.ajrpachon.data.remote.charactercomic.CharacterComicWs
import es.ajrpachon.data.remote.characters.CharacterRemoteDataSourceImpl
import es.ajrpachon.data.remote.characters.CharactersWs
import es.ajrpachon.data.remote.comicdetail.ComicDetailRemoteDataSourceImpl
import es.ajrpachon.data.remote.comicdetail.ComicDetailWs
import okhttp3.Interceptor
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.moshi.MoshiConverterFactory
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
class RemoteModule(
    private val endpoint: String = "https://gateway.marvel.com/v1/public/"
) {

    @Provides
    fun interceptorProvider(): Interceptor =
        HttpLoggingInterceptor().apply {
            level = HttpLoggingInterceptor.Level.HEADERS
        }

    @Provides
    fun okHttpClientProvider(interceptor: Interceptor) =
        OkHttpClient.Builder()
            .addInterceptor(interceptor)
            .build()

    @Provides
    fun moshiProvider() =
        Moshi.Builder()
            .add(DateAdapter())
            .build()

    @Provides
    @Singleton
    fun retrofitProvider(okHttpClient: OkHttpClient, moshi: Moshi) =
        Retrofit.Builder()
            .client(okHttpClient)
            .baseUrl(endpoint)
            .addConverterFactory(MoshiConverterFactory.create(moshi))
            .build()

    @Provides
    fun characterServiceProvider(retrofit: Retrofit) =
        retrofit.create(CharactersWs::class.java)

    @Provides
    fun characterComicServiceProvider(retrofit: Retrofit) =
        retrofit.create(CharacterComicWs::class.java)

    @Provides
    fun comicDetailServiceProvider(retrofit: Retrofit) =
        retrofit.create(ComicDetailWs::class.java)

    @Provides
    fun characterListRemoteDataSourceProvider(charactersWs: CharactersWs) =
        CharacterRemoteDataSourceImpl(charactersWs) as CharacterRemoteDataSource

    @Provides
    fun characterComicListRemoteDataSourceProvider(characterComicWs: CharacterComicWs) =
        CharacterComicRemoteDataSourceImpl(characterComicWs) as CharacterComicRemoteDataSource

    @Provides
    fun comicDetailRemoteDataSourceProvider(comicDetailWs: ComicDetailWs) =
        ComicDetailRemoteDataSourceImpl(comicDetailWs) as ComicDetailRemoteDataSource

}