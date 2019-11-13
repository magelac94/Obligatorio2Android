package com.diegomedina.notesapp.data.service

import com.diegomedina.notesapp.data.model.Note
import retrofit2.http.GET


interface NoteService {
    @GET("movie/550?api_key=b047fda6c17df2280f374f88f849cbce")
    suspend fun getNotes(): List<Note>
}