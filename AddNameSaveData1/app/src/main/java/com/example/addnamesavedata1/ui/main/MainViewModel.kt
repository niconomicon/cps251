package com.example.addnamesavedata1.ui.main

import androidx.lifecycle.ViewModel

class MainViewModel : ViewModel() {
    // TODO: Implement the ViewModel


    fun saveName(){
        var userText = editTextName.text.toString()
        var namesList = "First Name"
        //do something with text
        var newList = namesList + userText
        textView.setText(newList)
        println(newList)

    }
}