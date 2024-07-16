package com.nurhossain.bmicalculator.viewmodels

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class BmiViewModel: ViewModel() {
    var bmi : MutableLiveData<Double> = MutableLiveData()
    var category : MutableLiveData<String> = MutableLiveData()
    fun calculateBmi( weight: Double,height: Double){
         bmi.value = weight / (height * height)

         category.value = when(String.format("%.1f",bmi.value).toDouble()){
            in 0.0 .. 18.4 -> underweight
            in 18.5 .. 24.9 -> normal
            in 25.0 .. 29.9-> overweight
            in 30.0 .. 34.9 -> obesity1
            in 35.0 .. 39.9 -> obesity2
            else -> obesity3
        }

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