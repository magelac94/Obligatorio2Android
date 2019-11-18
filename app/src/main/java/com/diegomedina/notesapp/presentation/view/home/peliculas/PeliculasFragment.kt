package com.diegomedina.notesapp.presentation.view.home.peliculas

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.SearchView
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.recyclerview.widget.LinearLayoutManager
import com.diegomedina.notesapp.R
import com.diegomedina.notesapp.data.model.Pelicula
import com.diegomedina.notesapp.presentation.helper.visibleIf
import kotlinx.android.synthetic.main.fragment_peliculas.*
import org.koin.androidx.viewmodel.ext.android.viewModel

class PeliculasFragment : Fragment() {

    private lateinit var adapter: GridAdapter

    private val peliculasViewModel: PeliculasViewModel by viewModel()

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {

        adapter = GridAdapter(context!!)

        return inflater.inflate(R.layout.fragment_peliculas, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)


        // grid
        grid_movies.adapter = adapter

        // barra de busqueda
        bar_search.setOnQueryTextListener(object : SearchView.OnQueryTextListener {

            override fun onQueryTextChange(newText: String): Boolean {
                peliculasViewModel.searchPeliculas(newText)
                return false
            }

            override fun onQueryTextSubmit(query: String): Boolean {
                peliculasViewModel.searchPeliculas(query)
                bar_search.clearFocus();
                return false
            }

        })

        peliculasViewModel.loadPeliculas()
        peliculasViewModel.peliculas.observe(viewLifecycleOwner, Observer(this::peliculasLoaded))
        peliculasViewModel.isLoading.observe(viewLifecycleOwner, Observer(this::loadingStateChanged))

    }

    private fun peliculasLoaded(peliculas: List<Pelicula>) {
        adapter.listapeliculas = peliculas
    }

    private fun loadingStateChanged(isLoading: Boolean) {
//        progressBar.visibleIf(isLoading)
//        recyclerView.visibleIf(!isLoading)
    }

//    private lateinit var adapter: PeliculasAdapter
//    private val moviesViewModel: PeliculasViewModel by viewModel()
//
//    override fun onCreateView(
//        inflater: LayoutInflater,
//        container: ViewGroup?,
//        savedInstanceState: Bundle?
//    ): View {
//
//        adapter = PeliculasAdapter()
//
//        return inflater.inflate(R.layout.fragment_peliculas, container, false)
//
//    }
//
//    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
//        super.onViewCreated(view, savedInstanceState)
//
//        // Init adapter
//        adapter = PeliculasAdapter()
//        //grid_movies.adapter = adapter
//
//        setupSearchBar()
//        moviesViewModel.loadPeliculas()
//        moviesViewModel.peliculas.observe(viewLifecycleOwner, Observer(this::moviesLoaded))
//        moviesViewModel.isLoading.observe(viewLifecycleOwner, Observer(this::loadingStateChanged))
//    }
//
//    private fun moviesLoaded(movies: List<Pelicula>) {
//        adapter.peliculas = movies
//    }
//
//    private fun loadingStateChanged(isLoading: Boolean) {
////        progressBar.visibleIf(isLoading)
////        movies_grid.visibleIf(!isLoading)
//    }
//
//    private fun setupSearchBar() {
//        bar_search.setOnQueryTextListener(object : SearchView.OnQueryTextListener {
//
//            override fun onQueryTextChange(newText: String): Boolean {
//                moviesViewModel.searchPeliculas(newText)
//                return false
//            }
//
//            override fun onQueryTextSubmit(query: String): Boolean {
//                moviesViewModel.searchPeliculas(query)
//                bar_search.clearFocus();
//                return false
//            }
//
//        })
//    }
}
