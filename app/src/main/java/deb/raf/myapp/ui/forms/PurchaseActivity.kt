package deb.raf.myapp.ui.forms

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import deb.raf.myapp.R
import deb.raf.myapp.database.Database
import deb.raf.myapp.model.Product
import deb.raf.myapp.model.Purchase
import deb.raf.myapp.ui.SignedActivity
import deb.raf.myapp.ui.lists.PlotOfLandList
import deb.raf.myapp.ui.lists.PurchaseList

class PurchaseActivity : AppCompatActivity() {

    private lateinit var backButton: Button
    private lateinit var purchase_productId_edittext: EditText
    private lateinit var purchase_qunatity_edittext: EditText
    private lateinit var save_button: Button
    private lateinit var getAll: Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_purchase)

        backButton = findViewById(R.id.back_toSignedActivity)
        purchase_productId_edittext = findViewById(R.id.purchase_productId_edittext)
        purchase_qunatity_edittext = findViewById(R.id.purchase_qunatity_edittext)
        save_button = findViewById(R.id.save_purchase)
        getAll = findViewById(R.id.get_all_purchases)

        backButton.setOnClickListener {
            goToSignedActivity()
        }

        save_button.setOnClickListener{
            addPurchase()
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
        val intent = Intent(this, PurchaseList::class.java)
        startActivity(intent)
        finish()
    }

    private fun addPurchase() {
        val productId = purchase_productId_edittext.text.toString().toInt()
        val quantity = purchase_qunatity_edittext.text.toString().toInt()

        val purchase = Purchase()
        purchase.productId = productId
        purchase.quantity = quantity
        Database.getDatabase(applicationContext)?.purchaseDao()?.addOne(purchase)
    }
}