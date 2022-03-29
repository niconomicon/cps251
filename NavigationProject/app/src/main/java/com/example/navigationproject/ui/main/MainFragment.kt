package com.example.navigationproject.ui.main

import androidx.lifecycle.ViewModelProvider
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.navigationproject.R
import androidx.navigation.Navigation

import com.example.navigationproject.databinding.MainFragmentBinding

class MainFragment : Fragment() {

    companion object {
        fun newInstance() = MainFragment()
    }

    private lateinit var viewModel: MainViewModel

    private var _binding: MainFragmentBinding? = null
    private val binding get() = _binding!!


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = MainFragmentBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        viewModel = ViewModelProvider(this).get(MainViewModel::class.java)

        binding.button.setOnClickListener {
            Navigation.findNavController(it).navigate(
                R.id.action_mainFragment_to_secondFragment1)
        }


        binding.button.setOnClickListener {
            val action: MainFragmentDirections.ActionMainFragmentToSecondFragment1  =  MainFragmentDirections.actionMainFragmentToSecondFragment1()

            //action.setMessage(binding.userText.text.toString())
            Navigation.findNavController(it).navigate(action)
        }
    }

}