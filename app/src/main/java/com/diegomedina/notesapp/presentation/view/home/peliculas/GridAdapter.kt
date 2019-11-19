package com.diegomedina.notesapp.presentation.view.home.peliculas

import kotlinx.android.synthetic.main.view_pelicula.view.*
import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.BaseAdapter
import android.widget.TextView
import com.diegomedina.notesapp.R
import com.diegomedina.notesapp.data.model.Pelicula
import com.squareup.picasso.Picasso


class GridAdapter: BaseAdapter {
    var context:Context

    var listapeliculas = listOf<Pelicula>()


    constructor(context: Context): super() {
        this.context = context
    }


    override fun getCount(): Int{
        return listapeliculas.size
    }

    override fun getItem(position: Int): Any {
        return listapeliculas.get(position)
    }

    override fun getItemId(position: Int): Long {
        return position.toLong()
    }

    override fun getView(position: Int, convertView: View?, parent: ViewGroup?): View {

        //mostrar en pantalla

        var layoutInflater = context!!.getSystemService(Context.LAYOUT_INFLATER_SERVICE) as LayoutInflater
        var convertView = layoutInflater.inflate(R.layout.view_pelicula, null)

        //titulo de la pelicula
        convertView.titulo_peli.text = listapeliculas[position].title
        println(listapeliculas[position].title)

        // imagen de la pelicula
        var url_image = listapeliculas[position].posterPath

       Picasso.get() //lib para uso imagenes por url
           .load(url_image)
           .resize(50, 50)
           .centerCrop()
           .into(convertView.image_peli)

       return convertView
    }


    // Guia Adapter para Grid: https://www.youtube.com/watch?v=DOXBg1HwXcI
}