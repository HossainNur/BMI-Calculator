package com.nurhossain.bmicalculator

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView

class ResultFragment : Fragment() {

    private lateinit var bmiScoreTv: TextView
    private lateinit var categoryTv: TextView
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.fragment_result, container, false)

        bmiScoreTv = view.findViewById(R.id.bmi_score_tv)
        categoryTv = view.findViewById(R.id.category_tv)
        val score = arguments?.getDouble("bmi_score")
        bmiScoreTv.text = String.format("%.1f",score)
        return view
    }

}