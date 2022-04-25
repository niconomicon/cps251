package com.ebookfrenzy.roomdemo

import android.app.Application
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import kotlinx.coroutines.*

class ProductRepository(application: Application) {

    val searchResults = MutableLiveData<List<Product>>()
    private var productDao: ProductDao?
    private val coroutineScope = CoroutineScope(Dispatchers.Main)
    val allProducts: LiveData<List<Product>>?
    //sort
    val ascSortedProducts: LiveData<List<Product>>?

    init {
        val db: ProductRoomDatabase? =
            ProductRoomDatabase.getDatabase(application)
        productDao = db?.productDao()
        allProducts = productDao?.getAllProducts()
        //call sort function from Dao
        ascSortedProducts = productDao?.ascSortProducts()
    }

    fun insertProduct(newproduct: Product) {
        coroutineScope.launch(Dispatchers.IO) {
            asyncInsert(newproduct)
        }
    }
    private suspend fun asyncInsert(product: Product) {
        productDao?.insertProduct(product)
    }

    fun deleteProduct(name: String) {
        coroutineScope.launch(Dispatchers.IO) {
            asyncDelete(name)
        }
    }
    private suspend fun asyncDelete(name: String) {
        productDao?.deleteProduct(name)
    }

    //add sort routines here somewhere
    /*fun ascSortProducts(name: String) {
        coroutineScope.launch(Dispatchers.Main) {
            searchResults.value = asyncFind(name).await()
        }
    }
    private suspend fun asyncFind(name: String): Deferred<List<Product>?> =
        coroutineScope.async(Dispatchers.IO) {
            return@async productDao?.findProduct(name)
        }*/

    fun findProduct(name: String) {
        coroutineScope.launch(Dispatchers.Main) {
            searchResults.value = asyncFind(name).await()
        }
    }
    private suspend fun asyncFind(name: String): Deferred<List<Product>?> =
        coroutineScope.async(Dispatchers.IO) {
            return@async productDao?.findProduct(name)
        }
}