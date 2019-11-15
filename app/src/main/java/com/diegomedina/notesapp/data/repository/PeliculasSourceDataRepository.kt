package com.diegomedina.notesapp.data.repository

import com.diegomedina.notesapp.data.model.Pelicula
import com.diegomedina.notesapp.data.repository.peliculas.PeliculasDataStoreFactory



class PeliculasSourceDataRepository(var factory: PeliculasDataStoreFactory) :
    PeliculasSourceRepository {

    override suspend fun getPeliculas(): List<Pelicula> {
        return factory.peliculasDataStoreFactory.getPeliculas()
    }

}