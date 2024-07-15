package com.nurhossain.bmicalculator

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import androidx.core.os.bundleOf
import androidx.navigation.fragment.findNavController
import com.nurhossain.bmicalculator.databinding.FragmentHomeBinding

class HomeFragment : Fragment() {

    /*private lateinit var weightEdit: EditText
    private lateinit var heightEdit: EditText
    private lateinit var calculateBtn: Button*/
    private lateinit var binding: FragmentHomeBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        //val view = inflater.inflate(R.layout.fragment_home, container, false)
        /*weightEdit = view.findViewById(R.id.editTextWeight)
        heightEdit = view.findViewById(R.id.editTextHeight)
        calculateBtn = view.findViewById(R.id.calculate_button)*/

        binding = FragmentHomeBinding.inflate(inflater,container,false)
        binding.calculateButton.setOnClickListener {
            val weight = binding.editTextWeight.text.toString().toDouble()
            val height = binding.editTextHeight.text.toString().toDouble()

            val bmi = weight / (height * height)
            //Toast.makeText(activity,bmi.toString(),Toast.LENGTH_LONG).show()
            val bundle = bundleOf("bmi_score" to bmi)
            findNavController().navigate(R.id.action_homeFragment_to_resultFragment,bundle)
        }
        return binding.root
    }

}