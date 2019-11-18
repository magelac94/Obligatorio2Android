package com.diegomedina.notesapp.data.repository.peliculas

import com.diegomedina.notesapp.data.dao.PeliculaDao
import com.diegomedina.notesapp.data.model.Pelicula

class DatabasePeliculasDataStore(private val peliculaDao: PeliculaDao) : PeliculasDataStore {

    override suspend fun getPeliculas(): List<Pelicula> {
        return peliculaDao.getAll()
    }

    override suspend fun searchPeliculas(query: String, voteAverage: Int?): List<Pelicula> {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }
}