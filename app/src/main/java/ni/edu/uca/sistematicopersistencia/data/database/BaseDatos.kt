package ni.edu.uca.sistematicopersistencia.data.database

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import ni.edu.uca.sistematicopersistencia.data.database.dao.ProductoDao
import ni.edu.uca.sistematicopersistencia.data.database.dao.UsuarioDao
import ni.edu.uca.sistematicopersistencia.data.database.entities.EntityProducto
import ni.edu.uca.sistematicopersistencia.data.database.entities.Usuario


@Database(entities = [EntityProducto::class, Usuario::class], version =1, exportSchema = false )
abstract class BaseDatos: RoomDatabase(){
    abstract fun productoDao(): ProductoDao
    abstract fun usuarioDao(): UsuarioDao

    companion object{
        @Volatile
        private var INSTANCE: BaseDatos?= null

        fun obtBaseDatos(context: Context):BaseDatos{
            return INSTANCE?: synchronized(this){
                val instance = Room.databaseBuilder(
                    context.applicationContext,
                    BaseDatos::class.java,
                    "basedatos"
                ).build()
                INSTANCE = instance
                instance
            }
        }
    }
}