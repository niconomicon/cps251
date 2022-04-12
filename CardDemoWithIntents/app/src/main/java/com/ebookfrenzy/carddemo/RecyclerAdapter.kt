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

    // created new Data class instance
    private lateinit var data: Data
    private lateinit var mainActivity: MainActivity

    private lateinit var binding: ActivityMainBinding

    inner class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {


        var itemImage: ImageView
        var itemTitle: TextView
        var itemDetail: TextView

        var randomImgNum: Int = 0

        init {
            itemImage = itemView.findViewById(R.id.itemImage)
            itemTitle = itemView.findViewById(R.id.itemTitle)
            itemDetail = itemView.findViewById(R.id.itemDetail)

            mainActivity = MainActivity()

            itemView.setOnClickListener { v: View ->
                var position: Int = getAdapterPosition()
                //added calls to title, details, and img data to make sure it's pulling the right info
                Snackbar.make(v, "Click detected on item $position, " + itemTitle.text + ", " + itemDetail.text  + ", Image #" + randomImgNum,
                    Snackbar.LENGTH_LONG).setAction("Action", null).show()

                // put intents info here (i think???)

                // Tried putting Intents info here, but it isn't an activity so it doesn't work
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

                // Tried calling method from Main Activity, but it breaks in sendText method on Intent creation line
                //mainActivity.sendText(itemView)


                //I don't think I need this, kept for reference
                //binding = ActivityMainBinding.bind(itemView)

            }
        }
    }

    //previous location of data, kept for reference
    /*
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
        */

    //mutable lists to hold randomized data for saved instance, so it can be displayed again when redrawn
    private var randomTitles = mutableListOf<Int>();
    private var randomDetails = mutableListOf<Int>();
    private var randomImages = mutableListOf<Int>();



    override fun onCreateViewHolder(viewGroup: ViewGroup, i: Int): ViewHolder {
        val v = LayoutInflater.from(viewGroup.context).inflate(R.layout.card_layout, viewGroup, false)
        return ViewHolder(v)

    }

    override fun onBindViewHolder(viewHolder: ViewHolder, i: Int) {
        // initialized instance of data class
        data = Data()

        // choosing random ints for array, between 0-7
        val randomTitle : Int = (0..7).random()
        val randomDetail : Int = (0..7).random()
        val randomImage : Int = (0..7).random()

        //add random image number to view holder variable so it can be called later
        viewHolder.randomImgNum = randomImage

        // randomizing data called from Data class
        viewHolder.itemTitle.text = data.getTitle(randomTitle)
        viewHolder.itemDetail.text = data.getDetail(randomDetail)
        viewHolder.itemImage.setImageResource(data.getImage(randomImage))

        //adding data to mutable lists in this class
        randomTitles.add(randomTitle)
        randomDetails.add(randomDetail)
        randomImages.add(randomImage)

        //adding data to mutable lists in Data class - doesn't work, new data instance is created each time so it only adds 1
        /*
        data.setRandomTitles(randomTitle)
        data.setRandomDetails(randomDetail)
        data.setRandomImages(randomImage)
        */

        //randomized data called from this class, kept for reference
        /*
        viewHolder.itemTitle.text = titles[randomTitle]
        println("Random Titles: "+ randomTitles)
        viewHolder.itemDetail.text = details[randomDetail]
        println("Random Details: "+ randomDetails)
        viewHolder.itemImage.setImageResource(images[randomImage])
        println("Random Images: "+ randomImages)
        */

        //un-randomized data called from this class, kept for reference
        /*
        viewHolder.itemTitle.text = titles[i]
        viewHolder.itemDetail.text = details[i]
        viewHolder.itemImage.setImageResource(images[i])
        */

        // testing variables, kept just for reference
        //var i: Int = (0..7).random()
        //println(data.getTitle((0..7).random()))
        //println("Random Titles: " + randomTitles)
        //println("Random Title #: " + randomTitle)
        //println("Random Detail #: "+ randomDetail)
        //println("Random Image #: " + randomImage)
        //println("Random Titles: "+ data.getRandomTitles())
        //println("Random Details: "+ data.getRandomDetails())
        //println("Random Images: "+ data.getRandomImages())

    }

    override fun getItemCount(): Int {
        //call to array in original location, kept for reference
        //return titles.size

        //initializing new instance of Data class and calling to array in Data class
        data = Data()
        return data.getTitles().size



    }
}