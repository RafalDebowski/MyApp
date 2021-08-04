package deb.raf.myapp.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import deb.raf.myapp.R
import deb.raf.myapp.model.Spraying

class SprayingAdapter(val sprayingList: List<Spraying>?) :
    RecyclerView.Adapter<SprayingAdapter.ViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): SprayingAdapter.ViewHolder {
        val layoutInflater = LayoutInflater.from(parent.context.applicationContext)
        val row = layoutInflater.inflate(R.layout.spraying_item, parent, false)
        return ViewHolder(row)
    }

    override fun onBindViewHolder(holder: SprayingAdapter.ViewHolder, position: Int) {
        holder.text1.text = "ID SESJI: " + sprayingList?.get(position)?.sprayingId
        holder.text2.text = "ID DZIAŁKI: " + sprayingList?.get(position)?.plotId
        holder.text3.text = "ID MAGAZYNU: " + sprayingList?.get(position)?.warehouseId
        holder.text4.text = "DATA SESJI: " + sprayingList?.get(position)?.date
        holder.text5.text = "UŻYTA ILOŚĆ: " + sprayingList?.get(position)?.usedAmount + " l/kg"
    }

    override fun getItemCount(): Int {
        return sprayingList!!.size
    }

    class ViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        var text1: TextView
        var text2: TextView
        var text3: TextView
        var text4: TextView
        var text5: TextView

        init {
            text1 = view.findViewById(R.id.text1)
            text2 = view.findViewById(R.id.text2)
            text3 = view.findViewById(R.id.text3)
            text4 = view.findViewById(R.id.text4)
            text5 = view.findViewById(R.id.text5)
        }

    }
}