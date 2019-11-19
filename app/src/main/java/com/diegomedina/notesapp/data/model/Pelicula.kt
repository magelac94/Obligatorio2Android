package com.diegomedina.notesapp.data.model

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import java.time.ZonedDateTime


@Entity
data class Pelicula(


    @PrimaryKey val id: Int,
    @ColumnInfo(name = "title") val title: String,
    @ColumnInfo(name = "vote_average") val voteAverage: Double,
    @ColumnInfo(name = "poster_path") val posterPath: String,
    @ColumnInfo(name = "overview") val overview: String,
    @ColumnInfo(name = "release_date") val releaseDate: String) {

}


//
//    @PrimaryKey val id: Int,
//    @ColumnInfo(name = "poster_path") val imagen: String,
//    @ColumnInfo(name = "title") val titulo: String,
//    @ColumnInfo(name = "vote_average") val raiting: Float,
//    @ColumnInfo(name = "overview") val descripcion: String
//
//)
//{
//}
