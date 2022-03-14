package com.example.addnamesavedata2project.ui.main

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import com.example.addnamesavedata2project.databinding.MainFragmentBinding

/*import com.ebookfrenzy.viewmodeldemo.R
import com.ebookfrenzy.viewmodeldemo.databinding.MainFragmentBinding*/

/*class MainFragment : Fragment() {

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

    private var _binding: MainFragmentBinding? = null
    private val binding get() = _binding!!
    //added resultSum variable
    var resultSum:String = "Nicole"

    companion object {
        fun newInstance() = MainFragment()
    }

    private lateinit var viewModel: MainViewModel

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

        /*NAMEOBSERVER FIRES WHEN IT SEES THAT NAME HAS CHANGED AND THEN THAT HAPPENS IT PUT THE VALUE INTO THE TEXT FIELD*/
        val nameObserver = Observer<String> {
                name -> binding.outputText.text = name.toString()
        }

        //THIS IS ACTUALLY DOING THE OBSERVING
        viewModel.getName().observe(viewLifecycleOwner, nameObserver)

        //CLICKING THIS BUTTON STARTS THE WHOLE PROCESS
        binding.displayNamesBtn.setOnClickListener {
            viewModel.changeText()

            //added resultSum handling
            val field1 = binding.inputText.text.toString()
            val field2 = binding.outputText.text.toString()
            resultSum = field1 + field2
        }
    }
}