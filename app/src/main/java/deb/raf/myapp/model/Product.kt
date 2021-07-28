package deb.raf.myapp.model

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import org.intellij.lang.annotations.Identifier

@Entity(tableName = "Products")
data class Product(
    @PrimaryKey(autoGenerate = true)
    var productId: Int? = null,

    @ColumnInfo(name = "name")
    var name: String = "",

    @ColumnInfo(name = "description")
    var description: String = ""
) {

}