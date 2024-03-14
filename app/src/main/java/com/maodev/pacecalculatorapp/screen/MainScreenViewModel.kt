package com.maodev.pacecalculatorapp.screen

import androidx.lifecycle.ViewModel

class MainScreenViewModel : ViewModel() {

    fun calculatePace(distance: Double, time: Double) :Double{
        return (time/distance)
    }

}