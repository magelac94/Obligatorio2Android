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
        var layoutInflater = context!!.getSystemService(Context.LAYOUT_INFLATER_SERVICE) as LayoutInflater
        var convertView = layoutInflater.inflate(R.layout.view_pelicula, null)

        convertView.text1.text = listapeliculas[position].titulo

        println("GET VIEW ------------------------ ????????????????")
        println(listapeliculas[position].titulo)

       return convertView
    }


    // Guia: https://www.youtube.com/watch?v=DOXBg1HwXcI
}