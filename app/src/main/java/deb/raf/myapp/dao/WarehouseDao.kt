package deb.raf.myapp.dao

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.Query
import deb.raf.myapp.model.User
import deb.raf.myapp.model.Warehouse

@Dao
interface WarehouseDao {

    @Query("SELECT * FROM warehouses")
    fun getAllWarehouses(): List<Warehouse>

    @Insert
    fun addAll(warehouses: List<Warehouse>)

    @Insert
    fun addOne(warehouse: Warehouse)

    @Delete
    fun deleteWarehouse(warehouse: Warehouse)
}