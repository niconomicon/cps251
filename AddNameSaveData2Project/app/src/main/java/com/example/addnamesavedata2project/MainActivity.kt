package com.example.addnamesavedata2project

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.addnamesavedata2project.ui.main.MainFragment

/*class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.main_activity)
        if (savedInstanceState == null) {
            supportFragmentManager.beginTransaction()
                .replace(R.id.container, MainFragment.newInstance())
                .commitNow()
        }
    }
}*/


/*import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.ebookfrenzy.viewmodeldemo.ui.main.MainFragment*/

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.main_activity)
        if (savedInstanceState == null) {
            supportFragmentManager.beginTransaction()
                .replace(R.id.container, MainFragment.newInstance())
                .commitNow()
        }
    }
}