package ni.edu.uca.sistematicopersistencia.data.database.dao

import androidx.lifecycle.LiveData
import androidx.room.*
import kotlinx.coroutines.flow.Flow
import ni.edu.uca.sistematicopersistencia.data.database.entities.EntityProducto
import ni.edu.uca.sistematicopersistencia.data.database.entities.Usuario

@Dao
interface UsuarioDao {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun inserUs(usuario: Usuario):Long

    @Update
    fun actualizarUs(usuario: Usuario): Int

    @Delete
    fun eliminarUs(usuario: Usuario): Int

    @Query("SELECT * FROM tblusuario")
    fun obtenerTodos(): LiveData<List<Usuario>>


}