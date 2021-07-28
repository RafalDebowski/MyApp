package deb.raf.myapp.ui.forms

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import deb.raf.myapp.R
import deb.raf.myapp.database.Database
import deb.raf.myapp.model.Purchase
import deb.raf.myapp.model.Spraying
import deb.raf.myapp.ui.SignedActivity

class SprayingActivity : AppCompatActivity() {

    private lateinit var backButton: Button
    private lateinit var spraying_warehouseId_edittext: EditText
    private lateinit var spraying_plotId_edittext: EditText
    private lateinit var spraying_usedAmount_edittext: EditText
    private lateinit var spraying_DATE_edittext: EditText
    private lateinit var save_button: Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_spraying)

        backButton = findViewById(R.id.back_toSignedActivity)

        spraying_warehouseId_edittext = findViewById(R.id.spraying_warehouseId_edittext)
        spraying_plotId_edittext = findViewById(R.id.spraying_plotId_edittext)
        spraying_usedAmount_edittext = findViewById(R.id.spraying_usedAmount_edittext)
        spraying_DATE_edittext = findViewById(R.id.spraying_DATE_edittext)
        save_button = findViewById(R.id.save_spraying)

        backButton.setOnClickListener {
            goToSignedActivity()
        }

        save_button.setOnClickListener{
            addSpraying()
        }
    }

    private fun goToSignedActivity() {
        val intent = Intent(this, SignedActivity::class.java)
        startActivity(intent)
        finish()
    }

    private fun addSpraying() {
        val warehouseId = spraying_warehouseId_edittext.text.toString().toInt()
        val plotId = spraying_plotId_edittext.text.toString().toInt()
        val usedAmount = spraying_usedAmount_edittext.text.toString().toInt()

        val spraying = Spraying()
        spraying.warehouseId = warehouseId
        spraying.plotId = plotId
        spraying.usedAmount = usedAmount

        Database.getDatabase(applicationContext)?.sprayingDao()?.addOne(spraying)
    }
}