package deb.raf.myapp.ui.forms

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import androidx.appcompat.app.AppCompatActivity
import deb.raf.myapp.R
import deb.raf.myapp.dao.ProductDao
import deb.raf.myapp.database.Database
import deb.raf.myapp.model.Product
import deb.raf.myapp.ui.SignedActivity

class ProductActivity : AppCompatActivity() {

    private lateinit var backButton: Button
    private lateinit var product_name_edittext: EditText
    private lateinit var product_description_edittext: EditText
    private lateinit var save_button: Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_product)

        backButton = findViewById(R.id.back_toSignedActivity)
        product_name_edittext = findViewById(R.id.product_name_edittext)
        product_description_edittext = findViewById(R.id.product_description_edittext)
        save_button = findViewById(R.id.save_product)

        backButton.setOnClickListener {
            goToSignedActivity()
        }

        save_button.setOnClickListener{
            addProduct()
        }


    }

    private fun goToSignedActivity() {
        val intent = Intent(this, SignedActivity::class.java)
        startActivity(intent)
        finish()
    }

    private fun addProduct() {
        val name = product_name_edittext.text.toString()
        val description = product_description_edittext.text.toString()
        val product = Product()
        product.name = name
        product.description = description

        Database.getDatabase(applicationContext)?.productDao()?.addOne(product)
    }
}