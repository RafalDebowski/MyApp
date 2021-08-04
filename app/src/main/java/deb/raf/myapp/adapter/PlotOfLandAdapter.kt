package deb.raf.myapp.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import deb.raf.myapp.R
import deb.raf.myapp.model.PlotOfLand

class PlotOfLandAdapter(val plotOfLandList: List<PlotOfLand>?) :
    RecyclerView.Adapter<PlotOfLandAdapter.ViewHolder>() {

    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): PlotOfLandAdapter.ViewHolder {
        val layoutInflater = LayoutInflater.from(parent.context.applicationContext)
        val row = layoutInflater.inflate(R.layout.list_item, parent, false)
        return ViewHolder(row)
    }

    override fun onBindViewHolder(holder: PlotOfLandAdapter.ViewHolder, position: Int) {
        holder.text1.text = "ID DZIAŁKI: " + plotOfLandList?.get(position)?.plotId.toString()
        holder.text2.text = "NAZWA: " + plotOfLandList?.get(position)?.name.toString()
        holder.text3.text = "LOKALIZACJA: " + plotOfLandList?.get(position)?.location.toString()
        holder.text4.text =
            "ROZMIAR DZIAŁKI: " + plotOfLandList?.get(position)?.size.toString() + " ha"
    }

    override fun getItemCount(): Int {
        return plotOfLandList!!.size
    }

    class ViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        var text1: TextView
        var text2: TextView
        var text3: TextView
        var text4: TextView

        init {
            text1 = view.findViewById(R.id.text1)
            text2 = view.findViewById(R.id.text2)
            text3 = view.findViewById(R.id.text3)
            text4 = view.findViewById(R.id.text4)
        }

    }
}