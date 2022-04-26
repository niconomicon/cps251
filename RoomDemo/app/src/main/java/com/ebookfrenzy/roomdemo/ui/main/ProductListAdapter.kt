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

    /*private var _binding: MainFragmentBinding? = null
    private val binding get() = _binding!!*/

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


        /*val id = holder.id
        productList.let {
            id.text = it!![listPosition].id.toString()
        }*/
        /*val deleteBtn = holder.deleteBtn
        productList.let {
            deleteBtn.setImageResource(parseInt(id.toString()))
        }*/

        /*deleteBtn.setOnClickListener(View.OnClickListener {
               //var id = productId.text.toString()
               var id = productId.text.toString()
               listener?.onClick(id)
               //Log.i("zzzz","contactListAdapter " + id)
        })*/


        /*val id = holder.id
        productList.let {
            id.text = it!![listPosition].id.toString()
        }*/
        //ADD HOLDER FOR IMAGE RESOURCE HERE
        /*val img = holder.img
        productList.let {
            img.setImageResource() = it!![listPosition].id.toString()
        }*/

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

        init {
            /*itemImage = itemView.findViewById(R.id.itemImage)
            itemTitle = itemView.findViewById(R.id.itemTitle)
            itemDetail = itemView.findViewById(R.id.itemDetail)*/

            itemView.setOnClickListener { v: View ->
                var position: Int = getAdapterPosition()
                Snackbar.make(v, "Click detected on item $position",
                    Snackbar.LENGTH_LONG).setAction("Action", null).show()



            }
        }
        //var id: TextView = itemView.findViewById(R.id.productID)
        //add separate image variable to each card
        //var deleteBtn: ImageView = itemView.findViewById(R.id.deleteBtn)

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