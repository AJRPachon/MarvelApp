package es.ajrpachon.data.local.di

import android.app.Application
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import es.ajrpachon.data.local.AppRoomDatabase
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object LocalModule {

    @Provides
    @Singleton
    fun appRoomDatabaseProvider(context: Application) =
        AppRoomDatabase.buildDatabase(context)

}