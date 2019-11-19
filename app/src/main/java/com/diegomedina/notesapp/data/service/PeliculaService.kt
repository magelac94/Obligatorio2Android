package com.diegomedina.notesapp.data.service

import com.diegomedina.notesapp.data.model.Pagina
import com.diegomedina.notesapp.data.model.Pelicula
import retrofit2.http.GET


interface PeliculaService {

    @GET("discover/movie?api_key=b047fda6c17df2280f374f88f849cbce&sort_by=popularity.desc")
    suspend fun getPeliculas(): Pagina

    @GET("/movie/550?api_key=b047fda6c17df2280f374f88f849cbce&language=en-US")
    suspend fun searchPeliculas(): List<Pelicula>

}