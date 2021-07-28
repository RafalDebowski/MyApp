package deb.raf.myapp.dao

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.Query
import deb.raf.myapp.model.Purchase
import deb.raf.myapp.model.User

@Dao
interface PurchaseDao {

    @Query("SELECT * FROM purchases")
    fun getAllPurchases(): List<Purchase>

    @Insert
    fun addAll(purchases: List<Purchase>)

    @Insert
    fun addOne(purchase: Purchase)

    @Delete
    fun deleteUser(purchase: Purchase)
}