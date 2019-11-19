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
import com.squareup.picasso.Picasso
import kotlinx.android.synthetic.main.fragment_peliculas.*
import kotlinx.android.synthetic.main.view_pelicula.*
import kotlinx.android.synthetic.main.view_pelicula.view.*
import kotlinx.android.synthetic.main.view_pelicula.view.image_peli
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

        Picasso.get()
            .load("https://www.sccpre.cat/maxp/iTbwoob/")
            .resize(50, 50)
            .centerCrop()
            .into(icon_app)

        // grid
        grid_movies.adapter = adapter

        // barra de busqueda
        // implementar

        // cargar peliculas
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


}
