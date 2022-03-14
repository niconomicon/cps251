package com.example.addnamesavedata2project.ui.main

/*class MainViewModel : ViewModel() {
    // TODO: Implement the ViewModel
}*/

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch

class MainViewModel : ViewModel() {

    val myCoroutineScope = CoroutineScope(Dispatchers.Main)

    //I HAD TO MAKE THIS PRIVATE OR IT WOULD CLASH WITH GETNAME FUNCTION AT THE BOTTOM
    private var name: MutableLiveData<String> = MutableLiveData()
    val names = arrayListOf<String>("Scott", "Karen", "Scottie", "Jazzy", "Oreo","Margaret","Jim","Danny","Michelle","Greg","Jackie","JACK","TYSON")

    //
    var _result = MutableLiveData<String>().apply { value = "Nicole" }
    val result: LiveData<String>
        get() = _result
    /*
    DISPLAYNAMES TAKES A RANDOM NAME FROM THE ARRAY AND SETS IT TO THE NAME VARIABLE ONCE IT IS THERE IT CALLS PAUSE WHICH PAUSES FOR 1 SECOND AND THEN CALLS DISPLAY NAMES AGAIN.  NOTICE THAT WHEN WE CHANGE THE VALUES OF NAMES THE UI DISPLAYS THE NEW VALUE (NAME) THAT IS BECAUSE THE OBSERVER IS SEEING THE CHANGE AND DISPLAYING IT.
     */
    fun displayNames() {
        val num = (0..(names.size - 1)).random()
        name.setValue(names[num])
        myCoroutineScope.launch(Dispatchers.Main) {
            pause()
        }
    }

    fun changeText(){
        name.setValue("Nicole")
        _result.value = "Nicole"
    }

    suspend fun pause(){
        delay(1000)
        displayNames()
    }

    fun getName(): MutableLiveData<String> {
        return name
    }
}