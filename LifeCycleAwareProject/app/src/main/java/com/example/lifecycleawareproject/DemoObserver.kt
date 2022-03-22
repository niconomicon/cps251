package com.example.lifecycleawareproject

import android.util.Log
import androidx.lifecycle.LifecycleObserver
import androidx.lifecycle.Lifecycle
import androidx.lifecycle.OnLifecycleEvent
import androidx.lifecycle.LifecycleOwner

import java.time.LocalDateTime

class DemoObserver: LifecycleObserver  {

    private val LOG_TAG = "DemoObserver"

    var logcatText: String = "Log Info should go here: \n"

    @OnLifecycleEvent(Lifecycle.Event.ON_RESUME)
    fun onResume() {
        Log.i(LOG_TAG, "onResume")
        logcatText += "onResume was fired on "+LocalDateTime.now().toString()+" \n"
        logcatText += "***** \n"
        println(logcatText)
    }

    @OnLifecycleEvent(Lifecycle.Event.ON_PAUSE)
    fun onPause() {
        Log.i(LOG_TAG, "onPause")
        logcatText += "onPause was fired on "+LocalDateTime.now().toString()+" \n"
        println(logcatText)
    }

    @OnLifecycleEvent(Lifecycle.Event.ON_CREATE)
    fun onCreate() {
        Log.i(LOG_TAG, "onCreate")
        logcatText += "onCreate was fired on "+LocalDateTime.now().toString()+" \n"
        println(logcatText)
    }

    @OnLifecycleEvent(Lifecycle.Event.ON_START)
    fun onStart() {
        Log.i(LOG_TAG, "onStart")
        logcatText += "onStart was fired on "+LocalDateTime.now().toString()+" \n"
        println(logcatText)
    }

    @OnLifecycleEvent(Lifecycle.Event.ON_STOP)
    fun onStop() {
        Log.i(LOG_TAG, "onStop")
        logcatText += "onStop was fired on "+LocalDateTime.now().toString()+" \n"
        println(logcatText)
    }

    @OnLifecycleEvent(Lifecycle.Event.ON_DESTROY)
    fun onDestroy() {
        Log.i(LOG_TAG, "onDestroy")
        logcatText += "onDestroy was fired on "+LocalDateTime.now().toString()+" \n"
        println(logcatText)
    }


    @OnLifecycleEvent(Lifecycle.Event.ON_ANY)
    fun onAny(owner: LifecycleOwner, event: Lifecycle.Event) {
        Log.i(LOG_TAG, owner.lifecycle.currentState.name)
        println(logcatText)

    }

    fun logInfo(): String {
        var finalLog = logcatText
        return finalLog
    }

}