package deb.raf.myapp.model

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "PlotsOfLand")
data class PlotOfLand(
    @PrimaryKey(autoGenerate = true)
    @ColumnInfo(name = "Plots")
    var plotId: Int? = null,

    @ColumnInfo(name = "Name")
    var name: String = "",

    @ColumnInfo(name = "Size")
    var size: Long? = null,

    @ColumnInfo(name = "Location")
    var location: String = ""
)