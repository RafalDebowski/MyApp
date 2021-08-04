package deb.raf.myapp.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import deb.raf.myapp.R
import deb.raf.myapp.model.Purchase

class PurchaseAdapter(val purchaseList: List<Purchase>?) :
    RecyclerView.Adapter<PurchaseAdapter.ViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): PurchaseAdapter.ViewHolder {
        val layoutInflater = LayoutInflater.from(parent.context.applicationContext)
        val row = layoutInflater.inflate(R.layout.purchase_item, parent, false)
        return ViewHolder(row)
    }

    override fun onBindViewHolder(holder: PurchaseAdapter.ViewHolder, position: Int) {
        holder.text1.text = "PURCHASE ID: " + purchaseList?.get(position)?.purchaseId
        holder.text2.text = "PRODUCT ID: " + purchaseList?.get(position)?.productId
        holder.text3.text = "DATE: " + purchaseList?.get(position)?.date
        holder.text4.text = "QUANTITY: " + purchaseList?.get(position)?.quantity
    }

    override fun getItemCount(): Int {
        return purchaseList!!.size
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