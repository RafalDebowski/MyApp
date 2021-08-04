package deb.raf.myapp.adapter

import deb.raf.myapp.model.Product

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import deb.raf.myapp.R


class ProductAdapter(val productList: List<Product>?) :
    RecyclerView.Adapter<ProductAdapter.ViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ProductAdapter.ViewHolder {
        val layoutInflater = LayoutInflater.from(parent.context.applicationContext)
        val row = layoutInflater.inflate(R.layout.product_item, parent, false)
        return ViewHolder(row)
    }

    override fun onBindViewHolder(holder: ProductAdapter.ViewHolder, position: Int) {
        holder.text1.text = "ID PRODUKTU: " + productList?.get(position)?.productId
        holder.text2.text = "NAZWA: " + productList?.get(position)?.name
        holder.text3.text = "OPIS: " + productList?.get(position)?.description
    }

    override fun getItemCount(): Int {
        return productList!!.size
    }

    class ViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        var text1: TextView
        var text2: TextView
        var text3: TextView

        init {
            text1 = view.findViewById(R.id.text1)
            text2 = view.findViewById(R.id.text2)
            text3 = view.findViewById(R.id.text3)
        }

    }
}