package com.maodev.pacecalculatorapp.screen

import androidx.lifecycle.ViewModel

class MainScreenViewModel : ViewModel() {

    fun calculatePace(
        distanceKm: Double,
        distanceMts: Double,
        timeHour: Double,
        timeMin: Double
    ): Double {
        val totalMin = timeMin + convertHoursToMin(timeHour)
        val distance = distanceKm + convertToKms(distanceMts)
        return (totalMin / distance)
    }

    private fun convertToKms(distanceMts: Double): Double {
        return distanceMts/1000

    }

    fun convertHoursToMin(hour: Double): Double {
        return hour * (60 / 1)
    }

}