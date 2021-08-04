package deb.raf.myapp.model

import android.os.Build
import androidx.annotation.RequiresApi
import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import java.text.SimpleDateFormat
import java.time.LocalDate
import java.time.LocalDateTime
import java.time.format.DateTimeFormatter
import java.time.format.DateTimeFormatterBuilder
import java.time.format.FormatStyle
import java.util.*

@Entity(tableName = "Purchases")
data class Purchase @RequiresApi(Build.VERSION_CODES.O) constructor(
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