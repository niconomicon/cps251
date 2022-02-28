package com.example.addnamesavedata1.ui.main

import androidx.lifecycle.ViewModel

class MainViewModel : ViewModel() {
    // TODO: Implement the ViewModel


    fun saveName(){
        var userText = textView.text.toString()
        textView4.setText(userText)
        //do something with text
        var namesList = ""
        var newList = namesList + userText
        println(newList)

    }
}