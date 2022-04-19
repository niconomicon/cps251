package com.ebookfrenzy.roomdemo.ui.main

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.ebookfrenzy.roomdemo.Product
import com.ebookfrenzy.roomdemo.R

//class ProductListAdapter(private val productItemLayout: Int) :
class ProductListAdapter(private val contactItemLayout: Int):
    RecyclerView.Adapter<ProductListAdapter.ViewHolder>() {

    private var productList: List<Product>? = null
    override fun onBindViewHolder(holder: ViewHolder, listPosition: Int) {
        val name = holder.name
        productList.let {
            name.text = it!![listPosition].productName
        }
        val phone = holder.phone
        productList.let {
            phone.text = it!![listPosition].quantity.toString()
        }

    }
    //ROOMDEMO
    /*override fun onCreateViewHolder(parent: ViewGroup, viewType: Int):
            ViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(
            productItemLayout, parent, false)
        return ViewHolder(view)
    }
*/

    //adapter = productListAdapter

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int):
            ViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(
            contactItemLayout, parent, false)
        return ViewHolder(view)
    }

    //FROM CARDDEMO
    /*override fun onCreateViewHolder(viewGroup: ViewGroup, i: Int): ViewHolder {
        val v = LayoutInflater.from(viewGroup.context)
            .inflate(R.layout.card_layout, viewGroup, false)
        return ViewHolder(v)
    }*/

    fun setProductList(products: List<Product>) {
        productList = products
        notifyDataSetChanged()
    }
    override fun getItemCount(): Int {
        return if (productList == null) 0 else productList!!.size
    }
    class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        var name: TextView = itemView.findViewById(R.id.card_product_row)
        var phone: TextView = itemView.findViewById(R.id.phone_number)
    }



    /* ViewHolder used to hold cards in CardDemo project example
    inner class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
    var itemImage: ImageView
    var itemTitle: TextView
    var itemDetail: TextView
        init {
        itemImage = itemView.findViewById(R.id.itemImage)
        itemTitle = itemView.findViewById(R.id.itemTitle)
        itemDetail = itemView.findViewById(R.id.itemDetail)
        }
    }
     */
}