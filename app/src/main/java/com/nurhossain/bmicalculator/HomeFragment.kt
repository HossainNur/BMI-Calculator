package com.nurhossain.bmicalculator

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.EditText

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

        }
        return view
    }

}