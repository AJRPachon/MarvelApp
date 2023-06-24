package es.ajrpachon.data.remote.di

import com.squareup.moshi.Moshi
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import okhttp3.Interceptor
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.moshi.MoshiConverterFactory
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
class RemoteModule(
    private val endpoint: String = "" //TODO BASE URL
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

}