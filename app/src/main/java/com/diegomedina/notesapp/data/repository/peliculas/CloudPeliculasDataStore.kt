package com.diegomedina.notesapp.data.repository.notes

import com.diegomedina.notesapp.data.model.Pelicula
import com.diegomedina.notesapp.data.service.PeliculaService

class CloudPeliculasDataStore(private var peliculaService: PeliculaService) : PeliculasDataStore {

    override suspend fun getPeliculas(): List<Pelicula> {
        return peliculaService.getPeliculas()
    }

}