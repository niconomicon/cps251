package com.ebookfrenzy.roomdemo.ui.main

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.ebookfrenzy.roomdemo.Product
import com.ebookfrenzy.roomdemo.R
import com.google.android.material.snackbar.Snackbar
import java.lang.Integer.parseInt

//class ProductListAdapter(private val productItemLayout: Int) :
class ProductListAdapter(private val contactItemLayout: Int):
    RecyclerView.Adapter<ProductListAdapter.ViewHolder>() {

    private var productList: List<Product>? = null
    //WE NEED THIS TO CALL THE ONCLICK IN THE ONBINDVIEWHOLDER
    var listener: onItemClickListener? = null
    //THIS IS CALLED WHEN SETTING IT TO THE ADAPTER
    fun settingListener(listener: onItemClickListener?) {
        this.listener = listener
    }
    interface onItemClickListener {
        fun onClick(str: String) //pass your object types.}
    }

    override fun onBindViewHolder(holder: ViewHolder, listPosition: Int) {
        val name = holder.name
        productList.let {
            name.text = it!![listPosition].productName
        }
        val phone = holder.phone
        productList.let {
            phone.text = it!![listPosition].quantity.toString()
        }

        //deleteBtn resource isn't recognized
      /*  deleteBtn.setOnClickListener(View.OnClickListener {
               var id = productId.text.toString()
               listener?.onClick(id)
        })*/

    }
    //adapter = productListAdapter

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int):
            ViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(
            contactItemLayout, parent, false)

        return ViewHolder(view)
    }

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

        init {
            itemView.setOnClickListener { v: View ->
                var position: Int = getAdapterPosition()
                Snackbar.make(v, "Click detected on item $position",
                    Snackbar.LENGTH_LONG).setAction("Action", null).show()
            }
        }
    }
}