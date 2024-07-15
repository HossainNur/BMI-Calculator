package com.nurhossain.bmicalculator

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import com.nurhossain.bmicalculator.databinding.FragmentResultBinding

class ResultFragment : Fragment() {

    /*private lateinit var bmiScoreTv: TextView
    private lateinit var categoryTv: TextView*/
    private lateinit var binding: FragmentResultBinding
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        //val view = inflater.inflate(R.layout.fragment_result, container, false)
        binding = FragmentResultBinding.inflate(inflater,container,false)

        /*bmiScoreTv = view.findViewById(R.id.bmi_score_tv)
        categoryTv = view.findViewById(R.id.category_tv)*/
        val score = arguments?.getDouble("bmi_score")
        binding.bmiScoreTv.text = String.format("%.1f",score)

        val category = when(String.format("%.1f",score).toDouble()){
            in 0.0 .. 18.4 -> underweight
            in 18.5 .. 24.9 -> normal
            in 25.0 .. 29.9-> overweight
            in 30.0 .. 34.9 -> obesity1
            in 35.0 .. 39.9 -> obesity2
            else -> obesity3
        }
        binding.categoryTv.text = category
        return binding.root
    }

    companion object{
        val underweight = "UNDER WEIGHT"
        val normal = "NORMAL"
        val overweight = "OVER WEIGHT"
        val obesity1 = "OBESITY CLASS 1"
        val obesity2 = "OBESITY CLASS 2"
        val obesity3 = "OBESITY CLASS 3"
    }

}