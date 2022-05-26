package br.ftdev.heroisdamarvel.domain.database

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import androidx.room.TypeConverters

@Database(entities = [HeroEntity::class], version = 1, exportSchema = false)
@TypeConverters(ThumbnailConverter::class)
abstract class HeroDatabase : RoomDatabase() {

    abstract fun heroDataAccess(): HeroDao

    companion object {

        private const val heroDatabaseName = "hero_database"

        fun loadDatabase(context: Context): HeroDao {
            return Room.databaseBuilder(
                context,
                HeroDatabase::class.java,
                heroDatabaseName
            ).build()
                .heroDataAccess()
        }

    }

}