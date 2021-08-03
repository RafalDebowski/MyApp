package deb.raf.myapp.ui.forms

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import deb.raf.myapp.R
import deb.raf.myapp.database.Database
import deb.raf.myapp.model.Spraying
import deb.raf.myapp.model.Warehouse
import deb.raf.myapp.ui.SignedActivity
import deb.raf.myapp.ui.lists.PlotOfLandList
import deb.raf.myapp.ui.lists.WarehouseList

class WarehouseActivity : AppCompatActivity() {

    private lateinit var backButton: Button
    private lateinit var warehouse_purchaseId_edittext: EditText
    private lateinit var save_button: Button
    private lateinit var getAll: Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_warehouse)

        backButton = findViewById(R.id.back_toSignedActivity)
        warehouse_purchaseId_edittext = findViewById(R.id.warehouse_purchaseId_edittext)
        save_button = findViewById(R.id.save_warehouse)
        getAll = findViewById(R.id.get_all_warehouses)

        backButton.setOnClickListener {
            goToSignedActivity()
        }

        save_button.setOnClickListener {
            addWarehouse()
        }

        getAll.setOnClickListener {
            startListActivity()
        }
    }

    private fun goToSignedActivity() {
        val intent = Intent(this, SignedActivity::class.java)
        startActivity(intent)
        finish()
    }

    private fun startListActivity() {
        val intent = Intent(this, WarehouseList::class.java)
        startActivity(intent)
        finish()
    }


    private fun addWarehouse() {
        val purchaseId = warehouse_purchaseId_edittext.text.toString().toInt()

        val warehouse = Warehouse()
        warehouse.purchaseId = purchaseId

        Database.getDatabase(applicationContext)?.warehouseDao()?.addOne(warehouse)
    }
}

