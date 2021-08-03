package deb.raf.myapp.ui.lists

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import deb.raf.myapp.R
import deb.raf.myapp.adapter.PlotOfLandAdapter
import deb.raf.myapp.database.Database
import deb.raf.myapp.model.PlotOfLand
import java.util.*

class PlotOfLandList : AppCompatActivity() {

    private  var plots : List<PlotOfLand>? = null
    private lateinit var recyclerView: RecyclerView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_plot_of_land_list)

        recyclerView = findViewById(R.id.recyclerviewList)
        recyclerView.layoutManager = LinearLayoutManager(applicationContext)

        updatePlotOfLandList()
        recyclerView.adapter = PlotOfLandAdapter(plots)

    }

     fun updatePlotOfLandList() {
         plots = Database.getDatabase(applicationContext)!!.plotOfLandDao()!!.getAllPlots()
     }
}