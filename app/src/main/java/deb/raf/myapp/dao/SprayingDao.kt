package deb.raf.myapp.dao

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.Query
import deb.raf.myapp.model.Spraying
import deb.raf.myapp.model.User

@Dao
interface SprayingDao {
    @Query("SELECT * FROM sprayings")
    fun getAllSprayings(): List<Spraying>

    @Insert
    fun addAll(sprayings: List<Spraying>)

    @Insert
    fun addOne(spraying: Spraying)

    @Delete
    fun deleteSpraying(spraying: Spraying)
}