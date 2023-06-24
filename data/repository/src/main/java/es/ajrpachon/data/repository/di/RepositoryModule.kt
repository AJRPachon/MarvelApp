package es.ajrpachon.data.repository.di

import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import es.ajrpachon.data.repository.util.AppDispatchers
import kotlinx.coroutines.Dispatchers

@Module
@InstallIn(SingletonComponent::class)
object RepositoryModule {

    @Provides
    fun appDispatchersProvider() =
        AppDispatchers(Dispatchers.Main, Dispatchers.Default, Dispatchers.IO)

}
