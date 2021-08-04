package deb.raf.myapp.ui.lists

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import deb.raf.myapp.R
import deb.raf.myapp.adapter.PlotOfLandAdapter
import deb.raf.myapp.adapter.WarehouseAdapter
import deb.raf.myapp.database.Database
import deb.raf.myapp.model.Warehouse
import deb.raf.myapp.ui.SignedActivity

class WarehouseList : AppCompatActivity() {

    private var warehouses: List<Warehouse>? = null
    private lateinit var recyclerView: RecyclerView
    private lateinit var buttonBack: Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_warehouse_list)

        recyclerView = findViewById(R.id.recyclerviewList)
        recyclerView.layoutManager = LinearLayoutManager(applicationContext)

        updatePlotOfLandList()
        recyclerView.adapter = WarehouseAdapter(warehouses)

        buttonBack = findViewById(R.id.button_back)

        buttonBack.setOnClickListener {
            goToMenu()
        }
    }

    private fun goToMenu() {
        val intent = Intent(this, SignedActivity::class.java)
        startActivity(intent)
        finish()
    }

    fun updatePlotOfLandList() {
        warehouses = Database.getDatabase(applicationContext)!!.warehouseDao()!!.getAllWarehouses()
    }
}