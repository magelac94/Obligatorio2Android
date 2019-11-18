package com.diegomedina.notesapp.data.source

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import androidx.room.TypeConverters
import com.diegomedina.notesapp.data.helper.converter.Converters
import com.diegomedina.notesapp.data.dao.PeliculaDao
import com.diegomedina.notesapp.data.model.Pelicula

@Database(entities = [Pelicula::class], version = 1, exportSchema = false)
@TypeConverters(Converters::class)
abstract class AppDatabase : RoomDatabase() {
    abstract fun peliculaDao(): PeliculaDao

    companion object {
        private val LOG_TAG = AppDatabasePeliculas::class.java.canonicalName
        private val LOCK = Any()
        private val DATABASE_NAME = "personlist"
        private var instance: AppDatabasePeliculas? = null

        fun getInstance(context: Context): AppDatabasePeliculas {
            synchronized(LOCK) {
                if (instance == null) {
                    instance = Room.databaseBuilder<AppDatabasePeliculas>(
                        context.applicationContext,
                        AppDatabasePeliculas::class.java, DATABASE_NAME
                    )
                        .fallbackToDestructiveMigration()
                        .build()
                }
            }
            return instance!!
        }
    }
}