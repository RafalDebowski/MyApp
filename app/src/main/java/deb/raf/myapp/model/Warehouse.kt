package deb.raf.myapp.model

import androidx.room.Entity
import androidx.room.ForeignKey
import androidx.room.PrimaryKey

@Entity(tableName = "Warehouses")
data class Warehouse(
    @PrimaryKey(autoGenerate = true)
    var warehouseId: Int? = null,

//    @ForeignKey(
//        entity = Purchase::class,
//        parentColumns = arrayOf("purchaseId"),
//        childColumns = arrayOf("purchases"),
//        onDelete = ForeignKey.CASCADE
//    )
    var purchaseId: Int? = null
) {
}