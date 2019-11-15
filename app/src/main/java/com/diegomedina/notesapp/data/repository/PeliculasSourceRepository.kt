package com.diegomedina.notesapp.data.repository

import com.diegomedina.notesapp.data.model.Pelicula

interface PeliculasSourceRepository {

    suspend fun getPeliculas(): List<Pelicula>
}