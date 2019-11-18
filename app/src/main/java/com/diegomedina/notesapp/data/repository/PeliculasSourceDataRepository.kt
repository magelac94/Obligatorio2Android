package com.example.awesomemovies.data.repository

import com.diegomedina.notesapp.data.model.Pelicula
import com.diegomedina.notesapp.data.repository.PeliculasSourceRepository
import com.diegomedina.notesapp.data.repository.peliculas.PeliculasDataStoreFactory


class PeliculasSourceDataRepository (var factory: PeliculasDataStoreFactory) :
    PeliculasSourceRepository {

    override suspend fun getPeliculas(): List<Pelicula> {
        return factory.peliculasDataStoreFactory.getPeliculas()
    }

    override suspend fun searchPeliculas(query: String, voteAverage: Int?): List<Pelicula> {
        return factory.peliculasDataStoreFactory.searchPeliculas(query, voteAverage)
    }

}