package deb.raf.myapp.dao

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.Query
import deb.raf.myapp.model.PlotOfLand
import deb.raf.myapp.model.User

@Dao
interface PlotOfLandDao {
    @Query("SELECT * FROM plotsofland")
    fun getAllPlots(): List<PlotOfLand>

    @Insert
    fun addAll(plots: List<PlotOfLand>)

    @Insert
    fun addOne(plot: PlotOfLand)

    @Delete
    fun deletePlot(plot: PlotOfLand)
}