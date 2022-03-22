package com.example.lifecycleawareproject.ui.main

import androidx.lifecycle.ViewModelProvider
import android.os.Bundle
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.SavedStateViewModelFactory

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.lifecycleawareproject.R

import com.example.lifecycleawareproject.DemoObserver
import com.example.lifecycleawareproject.DemoOwner
import com.example.lifecycleawareproject.databinding.MainFragmentBinding
import java.time.LocalDateTime

/*
class MainFragment : Fragment() {

    companion object {
        fun newInstance() = MainFragment()
    }

    private lateinit var viewModel: MainViewModel

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        return inflater.inflate(R.layout.main_fragment, container, false)
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        viewModel = ViewModelProvider(this).get(MainViewModel::class.java)
        // TODO: Use the ViewModel
    }

}*/


class MainFragment : Fragment() {

    companion object {
        fun newInstance() = MainFragment()
    }

    private var _binding: MainFragmentBinding? = null
    private val binding get() = _binding!!

    private lateinit var viewModel: MainViewModel

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
//        return inflater.inflate(R.layout.main_fragment, container, false)
        _binding = MainFragmentBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }


    private lateinit var demoOwner: DemoOwner
    private lateinit var demoObserver: DemoObserver

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)


        viewModel = ViewModelProvider(this).get(MainViewModel::class.java)

        ///NEEDS WORK


        /*
        activity?.application?.let {
            val factory = SavedStateViewModelFactory(it, this)

            viewModel = ViewModelProvider(this, factory).get(MainViewModel::class.java)

            val resultObserver = Observer<Float> { result ->
                binding.resultText.text = result.toString()
            }

            viewModel.getResult().observe(viewLifecycleOwner, resultObserver)

            binding.convertButton.setOnClickListener {
                if (binding.dollarText.text.isNotEmpty()) {
                    viewModel.setAmount(binding.dollarText.text.toString())
                } else {
                    binding.resultText.text = "No Value"
                }
            }
        }
        */

        //NEEDS WORK

        /*if (binding.message.text.isNotEmpty()) {
            viewModel.setAmount(binding.message.text.toString())
        } else {*/
        //    binding.message.text = LocalDateTime.now().toString()
            //binding.message.text = LocalDateTime.now().toString()
           // binding.message.text = DemoObserver().logcatText
            //binding.message.text = DemoObserver().logcatText


      //  }


        lifecycle.addObserver(DemoObserver())

        //THESE METHODS ARE FOR THE CUSTOM CLASS.
        demoOwner = DemoOwner()
        demoOwner.startOwner()
        demoOwner.stopOwner()



       /* binding.showButton.setOnClickListener {
            if (binding.message.text.isNotEmpty()) {
                binding.message.text = "hello2?"+demoObserver.onResume().logcatInfo

            } else {
                binding.message.text = "Log info run at "+LocalDateTime.now().toString()
            }
        }*/
        demoObserver = DemoObserver()
        binding.message.text = demoObserver.logcatText
        println(demoObserver.logInfo())

       // binding.message.text ="hello2?"+demoObserver.logInfo()

    }

}
