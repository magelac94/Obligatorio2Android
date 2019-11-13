package com.diegomedina.notesapp.data.service

import com.diegomedina.notesapp.data.model.Note
import com.diegomedina.notesapp.data.model.Pelicula
import retrofit2.http.GET


interface PeliculaService {
//    @GET("movie/550?api_key=b047fda6c17df2280f374f88f849cbce")
//    suspend fun getPeliculas(): List<Pelicula>

    @GET("discover/movie")
    suspend fun getPeliculas(): List<Pelicula>

    @GET("search/movie")
    suspend fun searchPeliculas(): List<Pelicula>

}