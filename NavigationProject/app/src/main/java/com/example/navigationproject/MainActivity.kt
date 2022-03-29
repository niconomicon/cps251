package com.example.navigationproject

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.navigationproject.ui.main.MainFragment
import android.net.Uri


class MainActivity : AppCompatActivity(),
    SecondFragment.OnFragmentInteractionListener {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.main_activity)
    }

    override fun onFragmentInteraction(uri: Uri) {
    }

}