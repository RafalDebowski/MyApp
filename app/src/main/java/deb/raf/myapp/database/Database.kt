package deb.raf.myapp.database

import android.content.Context
import androidx.room.Room
import androidx.room.RoomDatabase
import deb.raf.myapp.dao.*
import deb.raf.myapp.model.*


@androidx.room.Database(
    entities = [User::class, Product::class, PlotOfLand::class, Purchase::class, Spraying::class, Warehouse::class ],
    version = 1,
    exportSchema = false
)
abstract class Database : RoomDatabase() {

    abstract fun userDao(): UserDao?
    abstract fun plotOfLandDao(): PlotOfLandDao?
    abstract fun productDao(): ProductDao?
    abstract fun purchaseDao(): PurchaseDao?
    abstract fun warehouseDao(): WarehouseDao?
    abstract fun sprayingDao(): SprayingDao?

    companion object {
        private const val DATABASE_NAME = "database.db"
        private var INSTANCE: Database? = null
        fun getDatabase(context: Context): Database? {
            if (INSTANCE == null) {
                INSTANCE = Room.databaseBuilder(
                    context.applicationContext,
                    Database::class.java, DATABASE_NAME
                )
                    .allowMainThreadQueries()
                    .fallbackToDestructiveMigration()
                    .build()
                return INSTANCE
            }
            return INSTANCE
        }

    }


}