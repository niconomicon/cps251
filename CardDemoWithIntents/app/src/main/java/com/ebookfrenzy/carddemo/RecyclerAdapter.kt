package com.ebookfrenzy.carddemo

import android.content.Context
import android.content.Intent
import android.view.LayoutInflater
import android.widget.ImageView
import android.widget.TextView
import android.view.View
import android.view.ViewGroup
import androidx.core.content.ContextCompat.startActivity
import androidx.recyclerview.widget.RecyclerView
import com.ebookfrenzy.carddemo.R
import com.google.android.material.snackbar.Snackbar
import com.ebookfrenzy.carddemo.Data
import com.ebookfrenzy.carddemo.databinding.ActivityMain2Binding
import com.ebookfrenzy.carddemo.databinding.ActivityMainBinding
import com.ebookfrenzy.carddemo.MainActivity
import kotlin.random.Random

class RecyclerAdapter : RecyclerView.Adapter<RecyclerAdapter.ViewHolder>() {

    private lateinit var data: Data
    private lateinit var mainActivity: MainActivity

    private lateinit var binding: ActivityMainBinding

    inner class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {


        var itemImage: ImageView
        var itemTitle: TextView
        var itemDetail: TextView

        //made a new variable so the random image number can be passed using Intents
        var randomImgNum: Int = 0

        init {
            itemImage = itemView.findViewById(R.id.itemImage)
            itemTitle = itemView.findViewById(R.id.itemTitle)
            itemDetail = itemView.findViewById(R.id.itemDetail)

            mainActivity = MainActivity()

            itemView.setOnClickListener { v: View ->
                var position: Int = getAdapterPosition()
                //added calls to title, details, and img data to make sure it's pulling the right info for Intents
                Snackbar.make(v, "Click detected on item $position, " + itemTitle.text + ", " + itemDetail.text  + ", Image #" + randomImgNum,
                    Snackbar.LENGTH_LONG).setAction("Action", null).show()


                // Tried putting Intents info here, but it isn't an activity so it didn't work
                /*val i = Intent(this, MainActivity2::class.java)

                    i.putExtra("myTitle", itemTitle.text)
                    i.putExtra("myDetails", itemDetail.text)
                    // i.putExtra("myImageInt", randomImage)
                    startActivity(i)
                    */

                // Tried putting Intents info here using a method to create context, but it doesn't work so I put it in the Main Activity
                /* fun sendText(context: Context) {
                     val i = Intent(context, MainActivity2::class.java)
                     val myTitle = itemTitle.text //.toString()
                     i.putExtra("myTitle", myTitle)
                     context.startActivity(i)
                     // i.putExtra("myDetails", itemDetail.text)
                     // val myString = binding.editText1.text.toString()
                 }*/

                // Tried calling method from Main Activity, but it breaks in the sendText method on the Intent creation line
                //mainActivity.sendText(itemView)

            }
        }
    }



    private var randomTitles = mutableListOf<Int>();
    private var randomDetails = mutableListOf<Int>();
    private var randomImages = mutableListOf<Int>();



    override fun onCreateViewHolder(viewGroup: ViewGroup, i: Int): ViewHolder {
        val v = LayoutInflater.from(viewGroup.context).inflate(R.layout.card_layout, viewGroup, false)
        return ViewHolder(v)

    }

    override fun onBindViewHolder(viewHolder: ViewHolder, i: Int) {

        data = Data()

        val randomTitle : Int = (0..7).random()
        val randomDetail : Int = (0..7).random()
        val randomImage : Int = (0..7).random()

        //add random number to view holder variable so it can be passed using Intents
        viewHolder.randomImgNum = randomImage

        viewHolder.itemTitle.text = data.getTitle(randomTitle)
        viewHolder.itemDetail.text = data.getDetail(randomDetail)
        viewHolder.itemImage.setImageResource(data.getImage(randomImage))

        randomTitles.add(randomTitle)
        randomDetails.add(randomDetail)
        randomImages.add(randomImage)

    }

    override fun getItemCount(): Int {

        data = Data()
        return data.getTitles().size

    }
}