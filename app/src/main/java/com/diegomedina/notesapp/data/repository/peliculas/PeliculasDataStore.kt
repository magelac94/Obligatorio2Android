package com.diegomedina.notesapp.data.repository.notes

import com.diegomedina.notesapp.data.model.Note
import com.diegomedina.notesapp.data.model.Pelicula

interface PeliculasDataStore {

    suspend fun getPeliculas(): List<Pelicula>
}