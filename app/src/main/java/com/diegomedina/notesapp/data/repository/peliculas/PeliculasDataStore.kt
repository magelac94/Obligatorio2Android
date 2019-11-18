package com.diegomedina.notesapp.data.repository.peliculas

import com.diegomedina.notesapp.data.model.Pelicula

interface PeliculasDataStore {

    suspend fun getPeliculas(): List<Pelicula>
    suspend fun searchPeliculas(query: String, voteAverage: Int?): List<Pelicula>

}