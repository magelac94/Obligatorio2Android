package com.diegomedina.notesapp.data.repository.notes

import com.diegomedina.notesapp.data.dao.NoteDao
import com.diegomedina.notesapp.data.dao.PeliculaDao
import com.diegomedina.notesapp.data.model.Note
import com.diegomedina.notesapp.data.model.Pelicula

class DatabasePeliculasDataStore(private val peliculaDao: PeliculaDao) : PeliculasDataStore {

    override suspend fun getPeliculas(): List<Pelicula> {
        return peliculaDao.getAll()
    }
}