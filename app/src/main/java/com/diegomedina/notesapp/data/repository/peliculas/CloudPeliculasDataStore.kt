package com.diegomedina.notesapp.data.repository.peliculas

import com.diegomedina.notesapp.data.model.Pagina
import com.diegomedina.notesapp.data.model.Pelicula
import com.diegomedina.notesapp.data.service.PeliculaService

class CloudPeliculasDataStore(private var peliculaService: PeliculaService) : PeliculasDataStore {

    override suspend fun getPeliculas(): List<Pelicula> {
        var peliculas = peliculaService.getPeliculas().results

        return peliculas
    }

    override suspend fun searchPeliculas(query: String, voteAverage: Int?): List<Pelicula> {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }
}