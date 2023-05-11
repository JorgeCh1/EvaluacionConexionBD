package ni.edu.uca.sistematicopersistencia.data.database.entities

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import ni.edu.uca.sistematicopersistencia.data.database.BaseDatos
import ni.edu.uca.sistematicopersistencia.data.database.dao.UsuarioDao

class UsuarioViewModel (application: Application) : AndroidViewModel(application) {
    private val usuarioDao: UsuarioDao

    init {
        val database = BaseDatos.obtBaseDatos(application.applicationContext)
        usuarioDao = database.usuarioDao()
    }

    suspend fun insertar(usuario: Usuario) = withContext(Dispatchers.IO) {
        usuarioDao.inserUs(usuario)
    }
    suspend fun actualizarUs(usuario: Usuario) = withContext(Dispatchers.IO){
        usuarioDao.actualizarUs(usuario)
    }
    suspend fun eliminarUs(usuario: Usuario) = withContext(Dispatchers.IO){
        usuarioDao.eliminarUs(usuario)
    }
    val todos: LiveData<List<Usuario>> = usuarioDao.obtenerTodos()


}