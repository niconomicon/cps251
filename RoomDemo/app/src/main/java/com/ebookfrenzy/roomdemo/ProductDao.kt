package com.ebookfrenzy.roomdemo

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query

@Dao
interface ProductDao {

    @Insert
    fun insertProduct(product: Product)

    //Replace Product with Contact
    //@Insert
    //fun insertContact(contact: Contact

    //Queries from the Project Instructions
    /*
    @Query("SELECT * FROM contacts WHERE contactName LIKE '%' || :name || '%'")
    @Query("DELETE FROM contacts WHERE contactId = :id")
    @Query("SELECT * FROM contacts")
    //THIS DOES THE ASC SORT FROM THE DATABASE
    @Query("SELECT * FROM contacts ORDER BY contactName ASC")
    //THIS DOES THE DESC SORT FROM THE DATABASE
    @Query("SELECT * FROM contacts ORDER BY contactName DESC")
    */

    //updated query using contacts query provided
    //@Query("SELECT * FROM products WHERE productName LIKE '%' || :name || '%'")
    //original query
    //@Query("SELECT * FROM products WHERE productName = :name")
    @Query("SELECT * FROM products WHERE productName LIKE '%' || :name || '%'")
    fun findProduct(name: String): List<Product>

   /* @Query("DELETE FROM products WHERE productName = :name")
    fun deleteProduct(name: String)*/
    @Query("DELETE FROM products WHERE productId = :id")
    fun deleteProduct(id: String)

    @Query("SELECT * FROM products")
    fun getAllProducts(): LiveData<List<Product>>

    //add sort here
    @Query("SELECT * FROM products ORDER BY productName ASC")
    fun ascSortContacts(): LiveData<List<Product>>

    @Query("SELECT * FROM products ORDER BY productName DESC")
    fun desSortContacts(): LiveData<List<Product>>

}