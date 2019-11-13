package com.diegomedina.notesapp.data.dao

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.Query
import com.diegomedina.notesapp.data.model.Pelicula

@Dao
interface PeliculaDao {

    @Query("SELECT * FROM pelicula")
    suspend fun getAll(): List<Pelicula>

    @Insert
    suspend fun insertAll(vararg notes: Pelicula)

    @Delete
    suspend fun delete(note: Pelicula)
}