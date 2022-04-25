package com.ebookfrenzy.roomdemo.ui.main

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.ebookfrenzy.roomdemo.Product
import com.ebookfrenzy.roomdemo.ProductRepository
//import androidx.lifecycle.ViewModel



class MainViewModel(application: Application) : AndroidViewModel(application) {
    // TODO: Implement the ViewModel
    private val repository: ProductRepository = ProductRepository(application)
    private val allProducts: LiveData<List<Product>>?
    private val searchResults: MutableLiveData<List<Product>>
    //add sort value here
    private val ascSortedProducts: LiveData<List<Product>>?
    private val desSortedProducts: LiveData<List<Product>>?

    init {
        allProducts = repository.allProducts
        searchResults = repository.searchResults
        //initilaize sort value here with call to Repository
        ascSortedProducts = repository.ascSortedProducts
        desSortedProducts = repository.desSortedProducts
    }

    fun insertProduct(product: Product) {
        repository.insertProduct(product)
    }
    fun findProduct(name: String) {
        repository.findProduct(name)
    }
    fun deleteProduct(name: String) {
        repository.deleteProduct(name)
    }

    //add SORT functions here
    fun getAscSortedProducts(): LiveData<List<Product>>? {
        return ascSortedProducts
    }
    fun getDesSortedProducts(): LiveData<List<Product>>? {
        return desSortedProducts
    }

    fun getSearchResults(): MutableLiveData<List<Product>> {
        return searchResults
    }
    fun getAllProducts(): LiveData<List<Product>>? {
        return allProducts
    }
}