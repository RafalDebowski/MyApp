package deb.raf.myapp.model

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.Ignore
import androidx.room.PrimaryKey
import java.io.Serializable

@Entity(tableName = "Users")
data class User(
    @PrimaryKey(autoGenerate = true)
    @ColumnInfo(name = "UserID")
    var UserId: Int? = null,

    @ColumnInfo(name = "Name")
    var name: String = "",

    @ColumnInfo(name = "Uid")
    var uid: String = "",

    @ColumnInfo(name = "email")
    var email: String = "",

    ) : Serializable {
    @Ignore
    val isAuthenticated: Boolean? = false

    var isNew: Boolean? = false
    var isCreated: Boolean? = false


}
