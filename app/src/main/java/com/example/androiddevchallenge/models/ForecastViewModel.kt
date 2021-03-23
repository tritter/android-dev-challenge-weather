package com.example.androiddevchallenge.models

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.launch

class ForecastViewModel: ViewModel() {
    var dayViewModels by mutableStateOf(emptyList<DayRowViewModel>())
    var location by mutableStateOf("")

    init {
        viewModelScope.launch {
            fetchData()
        }
    }

    private fun fetchData() {
        val appointments = generateAppointments()
        val forecast = generateForecast()
        location = forecast.location
        dayViewModels = forecast.days.map { DayRowViewModel(it, appointments) }
    }
}