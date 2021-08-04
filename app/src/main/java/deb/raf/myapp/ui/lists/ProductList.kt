package deb.raf.myapp.ui.lists

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import deb.raf.myapp.R
import deb.raf.myapp.adapter.PlotOfLandAdapter
import deb.raf.myapp.adapter.ProductAdapter
import deb.raf.myapp.database.Database
import deb.raf.myapp.model.PlotOfLand
import deb.raf.myapp.model.Product
import deb.raf.myapp.ui.SignedActivity
import java.util.*

class ProductList : AppCompatActivity() {

    private var products: List<Product>? = null
    private lateinit var recyclerView: RecyclerView
    private lateinit var buttonBack: Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_product_list)

        recyclerView = findViewById(R.id.recyclerviewList)
        recyclerView.layoutManager = LinearLayoutManager(applicationContext)

        updatePlotOfLandList()
        recyclerView.adapter = ProductAdapter(products)

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
        products = Database.getDatabase(applicationContext)!!.productDao()!!.getAllProducts()
    }
}