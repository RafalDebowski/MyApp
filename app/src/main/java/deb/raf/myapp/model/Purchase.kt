package deb.raf.myapp.model

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import java.time.LocalDate
import java.time.LocalDateTime
import java.util.*

@Entity(tableName = "Purchases")
data class Purchase(
    @PrimaryKey(autoGenerate = true)
    @ColumnInfo(name = "PurchaseID")
    var purchaseId: Int? = null,

    @ColumnInfo(name = "ProductID")
    var productId: Int? = null,

    @ColumnInfo(name = "Date")
    var date: String = Calendar.getInstance().time.toString(),

    @ColumnInfo(name = "Quantity")
    var quantity: Int? = null
) {
}