package com.ebookfrenzy.carddemo

import android.os.Bundle
import com.google.android.material.snackbar.Snackbar
import androidx.appcompat.app.AppCompatActivity
import androidx.navigation.findNavController
import androidx.navigation.ui.AppBarConfiguration
import androidx.navigation.ui.navigateUp
import androidx.navigation.ui.setupActionBarWithNavController
import android.view.Menu
import android.view.MenuItem
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.ebookfrenzy.carddemo.databinding.ActivityMain2Binding
import com.ebookfrenzy.carddemo.Data
import android.view.View
import android.content.Intent


class MainActivity2 : AppCompatActivity() {


    private lateinit var data: Data
    private lateinit var binding: ActivityMain2Binding


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityMain2Binding.inflate(layoutInflater)
        setContentView(binding.root)

        //retrieve intent values from Main Activity
        val extras = intent.extras ?: return
        val myTitle = extras.getString("myTitle")
        val myDetails = extras.getString("myDetails")
        val myImageInt = extras.getInt( "myImageInt")

        // bind intents to views in 2nd activity layout
        binding.titleText.text  = myTitle
        binding.detailText.text  = myDetails
        binding.img.setImageResource(data.getImage(myImageInt))

    }

}