package com.ebookfrenzy.carddemo

import android.content.Intent

class Data {

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

    //these do not work properly from this class, kept getters/setters just in case
    private var randomTitles = mutableListOf<Int>();
    private var randomDetails = mutableListOf<Int>();
    private var randomImages = mutableListOf<Int>();

    fun sendText(view: View) {

        val i = Intent()

        val myString = binding.editText1.text.toString()

        i.putExtra("qString", myString)

        i.putExtra("tag","scott")

        startActivityForResult(i, request_code)
    }

    //getters for arrays
    fun getTitles(): Array<String> {
        return titles
    }

    fun getDetails(): Array<String> {
        return details

    }
    fun getImages(): IntArray {
        return images

    }
    //getters for individual array elements
    fun getTitle(i: Int): String {
        return titles[i]
    }

    fun getDetail(i: Int): String {
        return details[i]
    }

    fun getImage(i: Int): Int {
        return images[i]
    }

    //getters & setters for mutable lists
    fun getRandomTitles(): MutableList<Int> {
        return randomTitles
    }
    fun getRandomDetails(): MutableList<Int> {
        return randomDetails
    }
    fun getRandomImages(): MutableList<Int> {
        return randomImages
    }
    fun setRandomTitles(i: Int) {
        randomTitles.add(i)
    }
    fun setRandomDetails(i: Int) {
        randomDetails.add(i)
    }
    fun setRandomImages(i: Int) {
        randomImages.add(i)
    }
}