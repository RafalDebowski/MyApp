package deb.raf.myapp.model

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.ForeignKey
import androidx.room.PrimaryKey
import java.time.LocalDate
import java.util.*

@Entity(tableName = "Sprayings")
data class Spraying(
    @PrimaryKey(autoGenerate = true)
    @ColumnInfo(name = "SprayingID")
    var sprayingId: Int? = null,

    @ColumnInfo(name = "WarehouseID")
//    @ForeignKey(
//        entity = Purchase::class,
//        parentColumns = arrayOf("warehouseId"),
//        childColumns = arrayOf("warehouses"),
//        onDelete = ForeignKey.CASCADE
//    )
    var warehouseId: Int? = null,

    @ColumnInfo(name = "PlotID")
//    @ForeignKey(
//        arrayOf(
//        entity = Purchase::class,
//        parentColumns = arrayOf("plotId"),
//        childColumns = arrayOf("plots"),
//        onDelete = ForeignKey.CASCADE)
//    )
    var plotId: Int? = null,
    @ColumnInfo(name = "UsedAmount")
    var usedAmount: Int? = null,
    @ColumnInfo(name = "Date")
    var date: String = Calendar.getInstance().time.toString()
) {
}