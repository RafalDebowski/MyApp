package deb.raf.myapp.dao

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.Query
import deb.raf.myapp.model.Product
import deb.raf.myapp.model.User

@Dao
interface ProductDao {

    @Query("SELECT * FROM products")
    fun getAllProducts(): List<Product>

    @Insert
    fun addAll(products: List<Product>)

    @Insert
    fun addOne(product: Product)

    @Delete
    fun deleteProduct(todo: User)
}