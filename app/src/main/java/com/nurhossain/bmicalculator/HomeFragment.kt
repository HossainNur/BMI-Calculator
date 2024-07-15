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

class HomeFragment : Fragment() {

    private lateinit var weightEdit: EditText
    private lateinit var heightEdit: EditText
    private lateinit var calculateBtn: Button

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.fragment_home, container, false)
        weightEdit = view.findViewById(R.id.editTextWeight)
        heightEdit = view.findViewById(R.id.editTextHeight)
        calculateBtn = view.findViewById(R.id.calculate_button)

        calculateBtn.setOnClickListener {
            val weight = weightEdit.text.toString().toDouble()
            val height = heightEdit.text.toString().toDouble()

            val bmi = weight / (height * height)
            //Toast.makeText(activity,bmi.toString(),Toast.LENGTH_LONG).show()
            val bundle = bundleOf("bmi_score" to bmi)
            findNavController().navigate(R.id.action_homeFragment_to_resultFragment,bundle)
        }
        return view
    }

}