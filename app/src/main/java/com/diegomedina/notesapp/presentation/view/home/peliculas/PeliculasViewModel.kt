package com.diegomedina.notesapp.presentation.view.home.peliculas

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.diegomedina.notesapp.data.model.Pelicula
import com.diegomedina.notesapp.data.repository.PeliculasSourceRepository
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlin.coroutines.CoroutineContext

class PeliculasViewModel(private val repository: PeliculasSourceRepository) : ViewModel(), CoroutineScope {
    override val coroutineContext: CoroutineContext
        get() = Dispatchers.Main

    val peliculas: LiveData<List<Pelicula>>
        get() = localPeliculas
    val isLoading: LiveData<Boolean>
        get() = localIsLoading

    private val localPeliculas = MutableLiveData<List<Pelicula>>()
    private val localIsLoading = MutableLiveData<Boolean>()

    fun loadPeliculas() {
        localIsLoading.postValue(true)
        launch(Dispatchers.IO) {
            try {
                val peliculas = repository.getPeliculas()
                localPeliculas.postValue(peliculas)
            } catch (error: Exception) {

            } finally {
                localIsLoading.postValue(false)
            }
        }
    }

    fun searchPeliculas(text: String) {
        launch(Dispatchers.IO) {
            try {
                val movies = repository.searchPeliculas(text, 0)
                if (!movies.isEmpty()) {
                    localPeliculas.postValue(movies)
                }

            } catch (error: Exception) {
                val a = error
            } finally {
                localIsLoading.postValue(false)
            }
        }
    }
}
