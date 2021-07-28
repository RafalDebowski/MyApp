package deb.raf.myapp.ui.forms

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import androidx.appcompat.app.AppCompatActivity
import deb.raf.myapp.R
import deb.raf.myapp.database.Database
import deb.raf.myapp.model.PlotOfLand
import deb.raf.myapp.ui.SignedActivity

class PlotOfLandActivity : AppCompatActivity() {

    private lateinit var backButton: Button
    private lateinit var plots: ArrayList<PlotOfLand>
    private lateinit var plot_name_edittext: EditText
    private lateinit var plot_size_edittext: EditText
    private lateinit var plot_location_edittext: EditText
    private lateinit var save_button: Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_plot_of_land)

        backButton = findViewById(R.id.back_toSignedActivity)
        plot_name_edittext = findViewById(R.id.plot_name_edittext)
        plot_size_edittext = findViewById(R.id.plot_size_edittext)
        plot_location_edittext = findViewById(R.id.plot_location_edittext)
        save_button = findViewById(R.id.save_plot_of_land)

        backButton.setOnClickListener {
            goToSignedActivity()
        }

        save_button.setOnClickListener{
            addPlot()
        }
    }

    private fun goToSignedActivity() {
        val intent = Intent(this, SignedActivity::class.java)
        startActivity(intent)
        finish()
    }

    private fun addPlot(){
        val name = plot_name_edittext.text.toString()
        val size = plot_size_edittext.text.toString().toLong()
        val location = plot_location_edittext.text.toString()
        val plot = PlotOfLand()
        plot.name = name
        plot.size = size
        plot.location = location

        Database.getDatabase(applicationContext)?.plotOfLandDao()?.addOne(plot)
    }
}
