package deb.raf.myapp.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import deb.raf.myapp.R
import deb.raf.myapp.model.Warehouse

class WarehouseAdapter( val warehouseList: List<Warehouse>?) : RecyclerView.Adapter<WarehouseAdapter.ViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): WarehouseAdapter.ViewHolder {
        val layoutInflater = LayoutInflater.from(parent.context.applicationContext)
        val row = layoutInflater.inflate(R.layout.warehouse_item, parent , false )
        return ViewHolder(row)
    }

    override fun onBindViewHolder(holder: WarehouseAdapter.ViewHolder, position: Int) {
        holder.text1.text = "PLOT ID: " + warehouseList?.get(position)?.purchaseId
        holder.text2.text = "NAME: " + warehouseList?.get(position)?.warehouseId
    }

    override fun getItemCount(): Int {
        return warehouseList!!.size
    }

    class ViewHolder(view: View) : RecyclerView.ViewHolder(view){
        var text1 : TextView
        var text2 : TextView

        init {
            text1 = view.findViewById(R.id.text1)
            text2 = view.findViewById(R.id.text2)
        }

    }
}