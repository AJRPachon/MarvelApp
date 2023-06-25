package es.ajrpachon.data.local

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import androidx.room.TypeConverters
import es.ajrpachon.data.local.converter.DateConverter

//@Database(entities = [], version = 1, exportSchema = false)
@TypeConverters(DateConverter::class)
abstract class AppRoomDatabase : RoomDatabase() {

    companion object {
        private const val DATABASE_NAME = "RoomDatabase.db"

        fun buildDatabase(context: Context) =
            Room.databaseBuilder(
                context.applicationContext,
                AppRoomDatabase::class.java,
                DATABASE_NAME
            ).build()
    }
}
