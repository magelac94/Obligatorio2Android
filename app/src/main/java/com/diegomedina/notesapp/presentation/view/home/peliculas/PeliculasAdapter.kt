
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.diegomedina.notesapp.R
import com.diegomedina.notesapp.data.model.Pelicula
import kotlinx.android.synthetic.main.view_note.view.*
import kotlinx.android.synthetic.main.view_pelicula.view.*
import org.threeten.bp.format.DateTimeFormatter

class PeliculasAdapter : RecyclerView.Adapter<PeliculasAdapter.PeliculaViewHolder>() {
    var peliculas = listOf<Pelicula>()
        set(value) {
            field = value
            notifyDataSetChanged()
        }

//    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): NoteViewHolder {
//        val view = LayoutInflater.from(context)
//            .inflate(R.layout.view_note, parent, false)
//
//        return NoteViewHolder(view)
//    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int) =
        LayoutInflater.from(parent.context)
            .inflate(R.layout.view_pelicula, parent, false)
            .let { view -> PeliculaViewHolder(view) }

    override fun getItemCount() = peliculas.size

    override fun onBindViewHolder(holder: PeliculaViewHolder, position: Int) {
        holder.bind(peliculas[position])
    }

    inner class PeliculaViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        fun bind(pelicula: Pelicula) {
//            itemView.contentTextView.text = pelicula.toString()
//            itemView.dateTextView.text = DateTimeFormatter
//                .ofPattern("dd MMMM, yyyy")
//                .format(pelicula.raiting)
        }
    }
}
