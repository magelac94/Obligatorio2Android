package com.diegomedina.notesapp.data.model

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.Ignore
import androidx.room.PrimaryKey
import org.threeten.bp.ZonedDateTime


@Entity
data class Note(
    @PrimaryKey val id: Int,
    @ColumnInfo val title: String,
    //@ColumnInfo val results: List<Movie>,
    @ColumnInfo(name = "created_by") val createdBy: String,
    @ColumnInfo(name = "created_at") val createdAt: ZonedDateTime,
    @ColumnInfo(name = "updated_at") val updatedAt: ZonedDateTime
)
//     {
//        constructor(id: Int, content: String, results: List<Movie>, createdBy: String) : this(
//            id,
//            content,
//            results,
//            createdBy,
//            ZonedDateTime.now(),
//            ZonedDateTime.now()
//        )
{
    constructor(id: Int, title: String, createdBy: String) : this(
        id,
        title,
        createdBy,
        ZonedDateTime.now(),
        ZonedDateTime.now()
    )
}


