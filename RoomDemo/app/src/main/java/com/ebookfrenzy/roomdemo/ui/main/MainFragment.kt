package com.ebookfrenzy.roomdemo.ui.main

import androidx.lifecycle.ViewModelProvider
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.ebookfrenzy.roomdemo.R

import androidx.lifecycle.Observer
import androidx.recyclerview.widget.LinearLayoutManager
import com.ebookfrenzy.roomdemo.Product
import androidx.fragment.app.viewModels
import java.util.*
import com.ebookfrenzy.roomdemo.databinding.MainFragmentBinding

class MainFragment : Fragment() {

    private var adapter: ProductListAdapter? = null

    companion object {
        fun newInstance() = MainFragment()
    }

    //private lateinit var viewModel: MainViewModel
    val viewModel: MainViewModel by viewModels()
    private var _binding: MainFragmentBinding? = null
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        //return inflater.inflate(R.layout.main_fragment, container, false)
        _binding = MainFragmentBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        //viewModel = ViewModelProvider(this).get(MainViewModel::class.java)
        listenerSetup()
        observerSetup()
        recyclerSetup()

    }

    private fun listenerSetup() {
        binding.addButton.setOnClickListener {
            val name = binding.productName.text.toString()
            val quantity = binding.productQuantity.text.toString()
            if (name != "" && quantity != "") {
                val product = Product(name, Integer.parseInt(quantity))
                viewModel.insertProduct(product)
                clearFields()
            } else {
                binding.productID.text = "Incomplete information"
            }
        }
        binding.findButton.setOnClickListener { viewModel.findProduct(
            binding.productName.text.toString()) }
        binding.deleteButton.setOnClickListener {
            viewModel.deleteProduct(binding.productName.text.toString())
            clearFields()
        }
        //add SORT listeners here
        binding.sortAscButton.setOnClickListener { viewModel.getAscSortedProducts()
            //added sort observer here instead - works!
            viewModel.getAscSortedProducts()?.observe(this, Observer { products ->
                products?.let {
                    adapter?.setProductList(it)
                    println("sort observer ran")
                }
            })

            clearFields()
            println("sort button clicked ran")}
    }

    private fun observerSetup() {
        viewModel.getAllProducts()?.observe(this, Observer { products ->
            products?.let {
                adapter?.setProductList(it)
            }
        })
        viewModel.getSearchResults().observe(this, Observer { products ->
            products?.let {
                if (it.isNotEmpty()) {
                    binding.productID.text = String.format(Locale.US, "%d", it[0].id)
                    binding.productName.setText(it[0].productName)
                    binding.productQuantity.setText(String.format(Locale.US, "%d",
                        it[0].quantity))
                } else {
                    binding.productID.text = "No Match"
                }
            }
        })
        //add sort observer?
        /*viewModel.getAscSortedProducts()?.observe(this, Observer { products ->
            products?.let {
                adapter?.setProductList(it)
                println("sort observer ran")
            }
        })*/
    }

    private fun recyclerSetup() {
        //card layout needs to be called here
        //adapter = ProductListAdapter(R.layout.product_list_item)
        adapter = ProductListAdapter(R.layout.card_layout)
        binding.productRecycler.layoutManager = LinearLayoutManager(context)
        binding.productRecycler.adapter = adapter
    }

    private fun clearFields() {
        binding.productID.text = ""
        binding.productName.setText("")
        binding.productQuantity.setText("")
    }

}