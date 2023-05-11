package ni.edu.uca.sistematicopersistencia.data.database.entities

import androidx.room.Entity
import androidx.room.PrimaryKey


@Entity(tableName = "tblusuario")
data class Usuario(
    @PrimaryKey(autoGenerate = true)
    val idUsuario: Int =0,
    val nombres: String?,
    val apellidos: String?,
    val correo: String?,
    val usuario: String?,
    val contraseña: String?,
    val rol: String?
)