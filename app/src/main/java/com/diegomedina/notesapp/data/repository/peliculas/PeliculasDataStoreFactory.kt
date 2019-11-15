
import com.diegomedina.notesapp.data.dao.PeliculaDao
import com.diegomedina.notesapp.data.helper.networking.NetworkingManager
import com.diegomedina.notesapp.data.repository.notes.PeliculasDataStore
import com.diegomedina.notesapp.data.service.PeliculaService

@Suppress("UNUSED_PARAMETER")
open class PeliculasDataStoreFactory(
    var service: PeliculaService,
    var dao: PeliculaDao,
    var networkingManager: NetworkingManager
) {

    open var peliculasDataStoreFactory: PeliculasDataStore
        get() {
            return createDataSourceFactory()
        }
        set(value) {}

    private fun createDataSourceFactory() = if (networkingManager.isNetworkOnline()) {
        CloudPeliculasDataStore(service)
    } else {
        DatabasePeliculasDataStore(dao)
    }
}