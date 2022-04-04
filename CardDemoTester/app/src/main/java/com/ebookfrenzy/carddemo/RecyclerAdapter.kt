package com.ebookfrenzy.carddemo

import android.view.LayoutInflater
import android.widget.ImageView
import android.widget.TextView
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.ebookfrenzy.carddemo.R
import com.ebookfrenzy.carddemo.Data
import com.google.android.material.snackbar.Snackbar
import java.util.*

import kotlin.random.Random

class RecyclerAdapter : RecyclerView.Adapter<RecyclerAdapter.ViewHolder>() {



    inner class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {



        var itemImage: ImageView
        var itemTitle: TextView
        var itemDetail: TextView

        init {
            itemImage = itemView.findViewById(R.id.itemImage)
            itemTitle = itemView.findViewById(R.id.itemTitle)
            itemDetail = itemView.findViewById(R.id.itemDetail)



            itemView.setOnClickListener { v: View ->
                var position: Int = getAdapterPosition()
                Snackbar.make(v, "Click detected on item $position",
                    Snackbar.LENGTH_LONG).setAction("Action", null).show()
            }
        }
    }


    private val titles = arrayOf("Chapter One",
        "Chapter Two", "Chapter Three", "Chapter Four",
        "Chapter Five", "Chapter Six", "Chapter Seven",
        "Chapter Eight")
    private val details = arrayOf("Item one details", "Item two details",
        "Item three details", "Item four details",
        "Item five details", "Item six details",
        "Item seven details", "Item eight details")
    private val images = intArrayOf(R.drawable.android_image_1,
        R.drawable.android_image_2, R.drawable.android_image_3,
        R.drawable.android_image_4, R.drawable.android_image_5,
        R.drawable.android_image_6, R.drawable.android_image_7,
        R.drawable.android_image_8)

    private var randomTitles = mutableListOf<Int>();
    private var randomDetails = mutableListOf<Int>();
    private var randomImages = mutableListOf<Int>();

    private lateinit var data : Data


    override fun onCreateViewHolder(viewGroup: ViewGroup, i: Int): ViewHolder {
        val v = LayoutInflater.from(viewGroup.context).inflate(R.layout.card_layout, viewGroup, false)
        return ViewHolder(v)

    }

    override fun onBindViewHolder(viewHolder: ViewHolder, i: Int) {

        //var i: Int = (0..7).random()
        //println(testchange)

        //DATA CLASS TESTING
        data = Data()
        println(Arrays.toString(data.detailTester()) +" <-- Tester is Here")

        println("Random Titles: " + randomTitles)
        val randomTitle : Int = (0..7).random()
        println("Random Title #: " + randomTitle)
        val randomDetail : Int = (0..7).random()
        println("Random Detail #: "+ randomDetail)
        val randomImage : Int = (0..7).random()
        println("Random Image #: " + randomImage)

        viewHolder.itemTitle.text = titles[randomTitle]
        randomTitles.add(randomTitle)
        println("Random Titles: "+ randomTitles)

        //Arrays.toString(data.detailTester())

        viewHolder.itemDetail.text = details[randomDetail]
        randomDetails.add(randomDetail)
        println("Random Details: "+ randomDetails)

        viewHolder.itemImage.setImageResource(images[randomImage])
        randomImages.add(randomImage)
        println("Random Images: "+ randomImages)



        /*viewHolder.itemTitle.text = titles[i]
        viewHolder.itemDetail.text = details[i]
        viewHolder.itemImage.setImageResource(images[i])*/

    }

    override fun getItemCount(): Int {
        return titles.size
    }
}