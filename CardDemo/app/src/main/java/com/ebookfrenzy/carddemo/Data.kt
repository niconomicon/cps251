package com.ebookfrenzy.carddemo

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

    private var randomTitles = mutableListOf<Int>();
    private var randomDetails = mutableListOf<Int>();
    private var randomImages = mutableListOf<Int>();

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
}