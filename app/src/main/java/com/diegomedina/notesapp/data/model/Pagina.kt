package com.diegomedina.notesapp.data.model


data class Pagina(
    val page: Int,
    val total_results: Int,
    val total_pages: Int,
    val results: List<Pelicula>

)