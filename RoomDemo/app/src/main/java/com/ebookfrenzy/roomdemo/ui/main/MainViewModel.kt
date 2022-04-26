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
    private val ascSortedContacts: LiveData<List<Product>>?
    private val desSortedContacts: LiveData<List<Product>>?

    init {
        allProducts = repository.allProducts
        searchResults = repository.searchResults
        //initilaize sort value here with call to Repository
        ascSortedContacts = repository.ascSortedContacts
        desSortedContacts = repository.desSortedContacts
    }

    fun insertProduct(product: Product) {
        repository.insertProduct(product)
    }
    fun findProduct(name: String) {
        repository.findProduct(name)
    }
    fun deleteProduct(id: String) {
        repository.deleteProduct(id)
    }

    //add SORT functions here
    fun getAscSortedContacts(): LiveData<List<Product>>? {
        return ascSortedContacts
    }
    fun getDesSortedContacts(): LiveData<List<Product>>? {
        return desSortedContacts
    }

    fun getSearchResults(): MutableLiveData<List<Product>> {
        return searchResults
    }
    fun getAllProducts(): LiveData<List<Product>>? {
        return allProducts
    }
}