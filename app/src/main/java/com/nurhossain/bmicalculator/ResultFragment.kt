package com.nurhossain.bmicalculator

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.lifecycle.ViewModelProvider
import com.nurhossain.bmicalculator.databinding.FragmentResultBinding
import com.nurhossain.bmicalculator.viewmodels.BmiViewModel

class ResultFragment : Fragment() {

    /*private lateinit var bmiScoreTv: TextView
    private lateinit var categoryTv: TextView*/
    private lateinit var binding: FragmentResultBinding
    private lateinit var bmiViewModel: BmiViewModel
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        //val view = inflater.inflate(R.layout.fragment_result, container, false)
        binding = FragmentResultBinding.inflate(inflater,container,false)
        bmiViewModel = ViewModelProvider(requireActivity()).get(BmiViewModel::class.java)

        /*bmiScoreTv = view.findViewById(R.id.bmi_score_tv)
        categoryTv = view.findViewById(R.id.category_tv)*/
        //val score = arguments?.getDouble("bmi_score")

        bmiViewModel.bmi.observe(viewLifecycleOwner){bmi ->
            binding.bmiScoreTv.text = String.format("%.1f",bmi)
        }
        bmiViewModel.category.observe(viewLifecycleOwner){category ->
            binding.categoryTv.text = category
        }

        /*val category = when(String.format("%.1f",score).toDouble()){
            in 0.0 .. 18.4 -> underweight
            in 18.5 .. 24.9 -> normal
            in 25.0 .. 29.9-> overweight
            in 30.0 .. 34.9 -> obesity1
            in 35.0 .. 39.9 -> obesity2
            else -> obesity3
        }*/

        return binding.root
    }

   /* companion object{
        val underweight = "UNDER WEIGHT"
        val normal = "NORMAL"
        val overweight = "OVER WEIGHT"
        val obesity1 = "OBESITY CLASS 1"
        val obesity2 = "OBESITY CLASS 2"
        val obesity3 = "OBESITY CLASS 3"
    }*/

}